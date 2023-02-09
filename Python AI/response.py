import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

# Load the data from the CSV file
data = pd.read_csv("conversational_english.csv")

# Split the data into training and testing sets
training_data = data[:int(0.8 * len(data))]
testing_data = data[int(0.8 * len(data)):]

# Convert the text into numerical feature vectors using CountVectorizer
vectorizer = CountVectorizer()
text_features = vectorizer.fit_transform(training_data['text'])

# Train a Naive Bayes classifier on the training data
classifier = MultinomialNB().fit(text_features, training_data['label'])

# Continuously get user input and generate a response based on the label
while True:
    user_input = input("Enter a conversational text: ")
    if user_input == "exit":
        break
    user_input_features = vectorizer.transform([user_input])
    predicted_label = classifier.predict(user_input_features)[0]
    if predicted_label == 'joke_request':
        predicted_label = 'joke'
    response = data.loc[data['label'] == predicted_label, 'text'].sample().values[0]
    print(predicted_label," Response:", response)
    correct = input("Is this response correct? (yes/no): ")
    if correct == "no":
        new_label = input("Enter the correct label for the user input: ")
        new_response = input("Enter the correct response for the user input: ")
        new_data = pd.DataFrame({'text': [user_input], 'label': [new_label], 'response': [new_response]})
        data = data.append(new_data, ignore_index=True)
        data.to_csv("conversational_english.csv", index=False)