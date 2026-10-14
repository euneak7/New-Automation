
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Java and Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit(
                    testResults: '**/target/surefire-reports/*.xml',
                    allowEmptyResults: true
            )
        }

        success {
            echo 'Automation pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check Console Output.'
        }
    }
}
