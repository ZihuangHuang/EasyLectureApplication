# EasyLectureApplication
## CSC207 Group Project
## ℹ️ Overview

This EasyLectureApp is a Java-based application designed to help students and educators efficiently digest lecture content from YouTube videos. By automatically extracting transcriptions from YouTube lectures, the program generates concise summaries and creates quizzes based on the summarized content. This tool enhances learning by providing easy-to-understand summaries and interactive quizzes that can be shared with peers or used for self-assessment.


### ✍️ Authors
- __Huy Xuan Dang__
- __Zihuang Huang__
- __Nguyen Nam Anh Tran__
- __Eric Zhang__

## Table of Contents

- [Project Summary](https://github.com/ZihuangHuang/EasyLectureApplication/blob/main/README.md#ℹ%EF%B8%8F-overview)(above)

- Authors--you are here!

- [Features of the software](https://github.com/ZihuangHuang/EasyLectureApplication/blob/main/README.md#-features)
- [Installation Instructions](https://github.com/ZihuangHuang/EasyLectureApplication/blob/main/README.md#%EF%B8%8F-installation)
- [Usage Guide]
- [License about Usage]
- [Feedback]
- [How to Contribute to this Software?]

***
## 🌟 Features
- Automatic Transcription Retrieval: Input a YouTube lecture URL, and the program fetches the lecture's transcription.
- Summarization: Generates concise summaries of lectures using advanced language models.
- Quiz Generation: Creates quizzes based on the lecture summaries to test comprehension.
- User-Friendly Interface: Simple and intuitive GUI built with Java Swing.
- Shareable Content: Summaries and quizzes can be shared with other students or educators.
- Customization: Adjust the depth of summaries and difficulty of quizzes (future enhancement).

Below are some visuals of our features!
![3751732835699_ pic](https://github.com/user-attachments/assets/a4ea09ac-5baf-4cae-a59c-d6ec6cf3fc00)
![3761732835700_ pic](https://github.com/user-attachments/assets/7d77bdef-79b0-433a-8b4b-71733edf42df)
***
## ⬇️ Installation
If you are instrested in using the application, follow these steps to install and run the Lecture Summarizer and Quiz Generator on your system.
### Prerequisites before using the app
- Operating System: Windows, macOS, or Linux
- Java Development Kit (JDK): Version 11 or higher
- Gradle: Version 6.0 or higher (optional, for building the project)
- Internet Connection: Required for fetching transcriptions and using the Cohere API
- Cohere API Key: Sign up at Cohere Platform to obtain an API key

### Required Libraries and Dependencies

- Cohere Java SDK: For language processing
- OkHttp: HTTP client for network requests
- Jackson Databind: For JSON processing
- JUnit Jupiter: For running tests

### Installation Steps
1. Open your terminal and run the command:
```bash
git clone https://github.com/yourusername/EasyLectureApplication.git
```
2. Navigate to the project directory:
```bash
cd EasyLectureApplication
```
3. Set up your Cohere API key:
- Obtain your API key from Cohere Platform.
- Create a file named config.properties in the src/main/resources directory.
- Add the following line to the file
```vbnet
cohere.api.key=YOUR_COHERE_API_KEY
```
4. Build the project using wrapper
```bash
./gradlew build
```
or using local Gradle installation
```bash
gradle build
```
5. Run the command to use
```bash
./gradlew run
```

### Common Issues and Solutions
- Gradle Not Found Error: Ensure that you have Gradle installed or use the Gradle wrapper (gradlew).
- Invalid API Key Error: Double-check that your Cohere API key is correct and placed in the config.properties file.
- Network Issues: Ensure that you have a stable internet connection.
***

## 🚀 Usage


Team Members:

Zihuang Huang, ZihuangHuang User story: As a student replies on visual aids for better understanding, I need a tool that specifically focuses on presentation and accessibility of information.So I want the program to highlight key concepts within the transcription and summarize the contents in bullet form as a way to help me jot down the notes in case I miss any important info.

Huy Dang, huyxdang User story: As a student, I want the ability to quickly get the main ideas of a lecture before actually diving into it, as well as rapid assessment and feedback on my understanding by quizzes based on the lecture content.
Proposed edit: As a student who’s first language is not English, I struggle when listening to lectures and online videos. Thus, I want a program that is able to transcribe my videos into a written script so that I can read and understand the content better.

Eric Zhang, happycompsci User story: As a student who learns best by testing myself, I want a program that can transform content from my recorded lectures and content videos into quizzes that I can use to test my knowledge. Since I study best with multiple choice quizzes, I want my program to be able to generate as many questions as I need based on a single lecture video.

Ken Tran, kensington21 User story:  As a student who loves to study in groups, I want to create quizzes that I can hand out to everyone based on each lecture that we attend. I am looking for a program that can generate quiz questions based on a recorded lecture or content video, which I can then use to help my study group.


Team User Story: As a student, I want the ability to quickly get the main ideas of a lecture before actually diving into it, as well as rapid assessment and feedback on my understanding by quizzes based on the lecture content.
