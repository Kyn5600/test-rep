import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
import random 
import os
import warnings
warnings.filterwarnings("ignore", category=FutureWarning)

os.system("cls")
# Labels:
# joke_request joke regque regresponse greeting farewell feeling_question feeling_reponse

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

correct = ''
last_input =''

# Continuously get user input and generate a response based on the label
while True:
    randomNum = random.randint(0,50)
    user_input = input("You: ")
    if user_input == "exit":
        break
    else:
        if user_input == 'wrong':
            new_label = input("Enter the correct label for the user input: ")
            if user_input in data['text'].values:
                continue
            else:
                newest_data = pd.DataFrame({'text': [last_input], 'label': [new_label]})
                data = data.append(newest_data, ignore_index=True)
                data.to_csv("conversational_english.csv", index=False)
        else:
            user_input_features = vectorizer.transform([user_input])
            predicted_label = classifier.predict(user_input_features)[0]
            if predicted_label == 'joke_request':
                predicted_label = 'joke'
            if predicted_label == 'feeling_question':
                predicted_label = 'feeling_response'
            if predicted_label == 'regque':
                predicted_label = 'regresponse'
            if predicted_label == 'fav_col_que':
                predicted_label = 'fav_color_response'
            if predicted_label == 'fav_food_que':
                predicted_label = 'fav_food_response'
            if predicted_label == 'fav_book_que':
                predicted_label = 'fav_book_response'
            response = data.loc[data['label'] == predicted_label, 'text'].sample().values[0]
            print("Bot:", response)
            last_input = user_input
            if predicted_label == 'feeling_response' and randomNum>=25:
                print(data.loc[data['label'] == 'feeling_question', 'text'].sample().values[0])
                new_user_input = input("You: ")
                if new_user_input == 'wrong':
                    new_label = input("Enter the correct label for the user input: ")
                    if user_input in data['text'].values:
                        continue
                    else:
                        newest_data = pd.DataFrame({'text': [last_input], 'label': [new_label]})
                        data = data.append(newest_data, ignore_index=True)
                        data.to_csv("conversational_english.csv", index=False)
                else:
                    predicted_label = 'feeling_response'
                    newest_data = pd.DataFrame({'text': [new_user_input], 'label': [predicted_label]})
                    data = data.append(newest_data, ignore_index=True)
                    data.to_csv("conversational_english.csv", index=False)
            if user_input in data['text'].values:
                continue
            else:
                newest_data = pd.DataFrame({'text': [user_input], 'label': [predicted_label]})
                data = data.append(newest_data, ignore_index=True)
                data.to_csv("conversational_english.csv", index=False)