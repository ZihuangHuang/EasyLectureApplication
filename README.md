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
- [Usage Guide](https://github.com/ZihuangHuang/EasyLectureApplication/blob/main/README.md#-usage)
- [License about Usage](https://github.com/ZihuangHuang/EasyLectureApplication#-license)
- [Feedback and Contributing](https://github.com/ZihuangHuang/EasyLectureApplication/edit/main/README.md#-feedback-and-contributing)

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
Once the application is running, follow these steps to use software.
1. Enter a YouTube Lecture URL

   - In the input field labeled "YouTube Lecture URL", paste the URL of the lecture you wish to summarize.
   - Example:
   ```bash
    (https://www.youtube.com/watch?v=dQw4w9WgXcQ)
   ```

2. Summarize the lecture
- Click the "Generate Summary" button.
- Wait for the application to fetch the transcription and generate the summary.
- The summary will be displayed in the "Lecture Summary" user interface.

3. Generate a quiz
- After the summary is displayed, click the "Generate Quiz" button.
- The application will create a quiz based on the summary.
- The quiz questions will appear in the "Quiz" section.
***
## 📋 License
This application is licensed under the MIT License.
```css
MIT License

Copyright (c) 2024 ZihuangHuang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
***
## 💭 Feedback and Contributing
Thanks for reading to this point! We as a team greatly value your feedback! To provide feedback on the EasyLectureApplication, please follow these steps:

- Submit Feedback via Google Forms:
   - Access the feedback form [here](https://docs.google.com/forms/d/1HXSokz-nm3lcJS2lld5WG_Lf99iJXazquqNv4RVzpfs/edit).
   - Provide detailed information about your experience, including any issues you encountered during usage or suggestions for future improvements.
   - Please be respectful and constructive in your feedback, please write at lest 3 sentences as a paragraph.
- Feedback Guidelines:
  - Valid feedback includes, but not limited to, bug reports, feature requests, usability issues, and general suggestions.📢❗🚨
  - Response Time: We aim to review and respond to feedback within two weeks.💪

We welcome the contributions from large community! If you are interested in becoming a contributor of our program, please click the "Fork" button on the top-right corner of the GitHub repository page, then clone your fork to make a local repo and create a new branch for each contributors. When making changes, please make sure to either implement your new functionality or fix a bug, write tests to ensure existing version works, and last but not least, follow the project's coding conventions!🤓 Always remember to git add commit and push, then Go to the original repository on GitHub, click on "Pull Requests" and then "New Pull Request", there you can provide a clear description of your changes.

### Contribution Guidelines
Good Pull Requests:
- Are focused on a single feature or fix.
- Include descriptive commit messages.
- Have been tested thoroughly.
- Follow the project's style guidelines.
  
Review Process:
- Contributions will be reviewed by the maintainers.
- Feedback may be provided for required changes.
- Approved contributions will be merged into the main branch.
***
## Again, contributions Are Welcome!
If you have any questions about contributing, feel free to open an issue or contact us at zihuang.huang@example.com.
