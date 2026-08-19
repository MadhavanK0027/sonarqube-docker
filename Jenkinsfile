pipeline {
    agent any

    tools {
<<<<<<< HEAD
        jdk 'java JDK 21'
=======
        jdk 'Java JDK 21'
>>>>>>> 8ff0270912d44364eef6b45a7ec07ee7800ee4dc
        maven 'Maven 3.9.16'
    }

    stages {

<<<<<<< HEAD
=======
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/MadhavanK0027/sonarqube-docker'
            }
        }

>>>>>>> 8ff0270912d44364eef6b45a7ec07ee7800ee4dc
        stage('Build & Test') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=sonarqube-docker'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
