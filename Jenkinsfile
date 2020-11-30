pipeline {
  agent {
    node {
      label 'slave-1'
    }

  }
  stages {
    stage('Checkout Slave 1') {
      parallel {
        stage('Checkout') {
          agent {
            node {
              label 'slave-1'
            }

          }
          steps {
            git(url: 'https://github.com/siddudubey/softmax-filters.git', branch: 'master')
          }
        }

        stage('Checkout Slave 2') {
          agent {
            node {
              label 'slave-2'
            }

          }
          steps {
            git(url: 'https://github.com/siddudubey/softmax-filters.git', branch: 'master')
          }
        }

      }
    }

    stage('Build Slave-1') {
      parallel {
        stage('Build Slave-1') {
          agent {
            node {
              label 'slave-1'
            }

          }
          steps {
            sh 'echo HELLO'
          }
        }

        stage('Build Slave-2') {
          agent {
            node {
              label 'slave-2'
            }

          }
          steps {
            sh 'echo HELLO'
          }
        }

      }
    }

  }
}