import re
import numpy as np
import random
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.linear_model import LogisticRegression

# Define a list of predefined responses
responses = [
    "Hello!",
    "I'm good, thanks for asking!",
    "Goodbye!",
    "I'm sorry, I don't understand.",
]

# Define a function to clean the user input
def clean_input(user_input):
    # Convert the user input to lowercase
    user_input = user_input.lower()
    # Remove any punctuation
    user_input = re.sub(r'[^\w\s]', '', user_input)
    return user_input

# Define a function to update the AI's knowledge
def update_knowledge(user_input, response):
    # Clean the user input
    user_input = clean_input(user_input)
    # Update the predefined responses
    responses.append(response)
    # Convert the updated predefined responses to a matrix of vectors
    global similarity_scores
    global vectorizer
    vectorizer = CountVectorizer()
    similarity_scores = vectorizer.fit_transform(responses).toarray()
    # Train the AI model
    global model
    X = similarity_scores
    y = [1] * len(responses)
    model = LogisticRegression().fit(X, y)

# Define a function to get the best response for the user input
def get_response(user_input, responses, similarity_scores, model):
    # Clean the user input
    user_input = clean_input(user_input)
    # Convert the user input to a vector
    user_input_vector = vectorizer.transform([user_input]).toarray()
    # Calculate the cosine similarity scores between the user input and the responses
    scores = cosine_similarity(user_input_vector, similarity_scores)
    # Predict the label for the user input using the AI model
    label = model.predict(user_input_vector)
    if label[0] == 1:
        # The user input is similar to one of the predefined responses
        index = np.argmax(scores)
        return responses[index]
    else:
        # The user input is not similar to any of the predefined responses
        return "I'm sorry, I don't understand."

# Convert the predefined responses to a matrix of vectors
vectorizer = CountVectorizer()
similarity_scores = vectorizer.fit_transform(responses).toarray()

# Train the AI model
X = similarity_scores
y = [1] * len(responses)
model = LogisticRegression().fit(X, y)

# Start a conversation with the user
while True:
    user_input = input("You: ")
    if user_input.lower() == "bye":
        break
    response = get_response(user_input, responses, similarity_scores, model)
    print("AI: " + response)
