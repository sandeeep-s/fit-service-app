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
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn exec:java -pl fit-service -Dexec.mainClass="com.gefa.fit.server.UndertowServer"'
                sh 'mvn -pl fit-service test'
            }
        }
    }
}