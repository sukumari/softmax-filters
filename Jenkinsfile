pipeline {
  agent any
  tools {
      // Install the Maven version configured as "my_mvn" and add it to the path.
      maven "my_mvn"
  }
  stages {
    stage('Build and Test') {
      parallel {

        stage('Checkout On Slave 1') {
          agent {
            node {
              label 'slave1'
            }
          }
          steps {
            git(url: 'https://github.com/sukumari/softmax-filters.git', branch: 'master')
          }
        }
        
        stage('Compile and Package On Slave 1') {
          agent {
            node {
              label 'slave1'
            }
          }
          steps {
            sh "mvn clean package"
          }
        }

        stage('Checkout On Slave 2') {
          agent {
            node {
              label 'slave2'
            }
          }
          steps {
            git(url: 'https://github.com/sukumari/softmax-filters.git', branch: 'master')
          }
        }
        
        stage('Unit Test On Slave 2') {
          agent {
            node {
              label 'slave2'
            }
          }
          steps {
            sh "mvn test"
          }
        }

      }
    }

  }
}
