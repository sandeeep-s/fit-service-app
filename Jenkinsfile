pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'cd fit-service && mvn -B -DskipTests clean package'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'cd fit-service && mvn test'
            }
        }
        stage('Integration Test') {
            steps {
                sh 'cd fit-service-rest-client && mvn test'
            }
        }
    }
}