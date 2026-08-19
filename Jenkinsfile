pipeline {

    agent any

    tools {
        jdk 'Java JDK 21'
        maven 'Maven 3.9.16'
    }

    stages {

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

        stage('Docker Build') {
            steps {
                bat 'docker build -t maddy0027/sonarqube-docker:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-credentials',
                        usernameVariable: 'DOCKER_USERNAME',
                        passwordVariable: 'DOCKER_PASSWORD'
                    )
                ]) {
                    bat '''
                    docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%
                    docker push maddy0027/sonarqube-docker:latest
                    docker logout
                    '''
                }
            }
        }
    }
}