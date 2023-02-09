import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

# Load the data from the CSV file
data = pd.read_csv("conversational_english.csv")
training_data = data[:int(0.8 * len(data))]
testing_data = data[int(0.8 * len(data)):]
vectorizer = CountVectorizer()
text_features = vectorizer.fit_transform(training_data['text'])
classifier = MultinomialNB().fit(text_features, training_data['label'])

data2 = pd.read_csv("conversational_english_responses.csv")
training_data2 = data2[:int(0.8 * len(data))]
testing_data2 = data2[int(0.8 * len(data)):]
vectorizer2 = CountVectorizer()
text_features2 = vectorizer2.fit_transform(training_data2['text'])
classifier2 = MultinomialNB().fit(text_features2, training_data2['label'])

# Continuously get user input and generate a response based on the label
while True:
    user_input = input("Enter a conversational text: ")
    if user_input == "exit":
        break
    user_input_features = vectorizer.transform([user_input])
    predicted_label = classifier.predict(user_input_features)[0]
    if predicted_label == 'joke_request':
        predicted_label = 'joke'
    response = data2.loc[data2['label'] == predicted_label, 'text'].sample().values[0]
    print(predicted_label," Response:", response)
    correct = input("Is this response correct? (yes/no): ")
    if correct == "no":
        new_label = input("Enter the correct label for the user input: ")
        new_response = input("Enter the correct response for the user input: ")

        new_data = pd.DataFrame({'text': [user_input], 'label': [new_label]})
        data = data.append(new_data, ignore_index=True)
        data.to_csv("conversational_english.csv", index=False)

        new_data2 = pd.DataFrame({'text': [new_response], 'label': [new_label]})
        data2 = data2.append(new_data2, ignore_index=True)
        data2.to_csv("conversational_english.csv", index=False)