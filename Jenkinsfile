pipeline {
  environment {
    finalNameApp = "wararojasu/user-register:${env.BUILD_NUMBER}"
    dockerAppImage = ''
  }
  
  agent any

  stages{
	stage('Build and Test'){
	   stages {
	      stage('Build') { 
	         steps {
	            sh './gradlew build'
	         }
	      }
	      stage('Test') { 
	         steps {
	               sh './gradlew test' 
	            }
	      }
		  stage('SonarQube') {
		     steps {
			    sh 'echo Sonar Analysis'
		        sh './gradlew sonarqube   -Dsonar.projectKey=wararojasu_user-register   -Dsonar.organization=wararojasu   -Dsonar.host.url=https://sonarcloud.io   -Dsonar.login=0c1a2f9ac99bcbfab13788e581bb497b115909aa'			
		     }
		  }		  
		}
       post {
          always {
             junit 'build/test-results/test/*.xml'
             archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true
		  
        // publish html

        publishHTML target: [

            allowMissing: false,

            alwaysLinkToLastBuild: false,

            keepAll: true,

            reportDir: 'build/reports/tests/test/',

            reportFiles: 'index.html',

            reportName: 'Report Unit Test'

          ]		  
          }
		 success {
		  sh 'echo "This will run only if successful"'
		  
		 }
		 failure {
		  sh 'echo "This will run only if failed"'
		  emailext attachmentsPattern: 'build/reports/tests/test/index.html', mimeType: 'text/html', body: '''${SCRIPT, template="groovy-html.template"}''', subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Failed", to: 'wara.rojas.u@gmail.com'
		 }
		 unstable {
		  sh 'echo "This will run only if the run was marked as unstable"'
          emailext attachmentsPattern: 'build/reports/tests/test/index.html', mimeType: 'text/html', body: '''${SCRIPT, template="groovy-html.template"}''', subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Unstable", to: 'wara.rojas.u@gmail.com'		  
		 }		 
		 changed {
		  sh 'echo "This will run only if the state of the Pipeline has changed"'
          
		 }		  
       }
    }
	stage('Build, Public image to Docker Registry'){
	   stages {
	      stage('Build ..') { 
	        steps {
			    script {
			       dockerAppImage = docker.build finalNameApp
			    }
	        }
	      }
	      stage('Public ..') { 
	        steps {
			    script {
				   docker.withRegistry( '', 'docker-hub-credentials' ) {
				      dockerAppImage.push()
				   }				   
			    }
	        }
	      }
       }
    }
	stage('Pull and Deploy ...'){
	   stages {
	      stage('Pull ..') { 
	        steps {
			    script {
				   docker.withRegistry('', 'docker-hub-credentials') {
					  dockerAppImage = docker.image(finalNameApp)
					  dockerAppImage.pull()
				  }				   
			    }
	        }
	      }
		  stage('Deploy Environments') {
		    steps {
			  parallel(
			    QA: {
				  sh 'docker run --name container-qa -d -p 8787:8080 wararojasu/user-register:1'
			    },
			    Dev: {
				  sh 'docker run --name container-dev -d -p 8785:8080 wararojasu/user-register:1' 
			    }
			  )
		    }
		  }		  
       }
    }
	stage('Build and Test GUI automation ...'){
	   stages {
          stage('Checkout external gui test ...') {
            steps {
				sh 'git clone -b master https://github.com/wararojasu/user-register-gui-test.git' 
            }
          }	   
	      stage('Build GUI tes') { 
	         steps {
			 sh 'pwd'
			 sh 'ls -l'
			    sh 'cd user-register-gui-test/ && ./gradlew build'
			 sh 'pwd'
			 sh 'ls -l'			 
	            sh './gradlew build'
	         }
	      }
	      stage('Test GUI test') { 
	         steps {
			 sh 'pwd'
			sh 'ls -l'
	               sh 'cd user-register-gui-test/ && ./gradleww test' 
			 sh 'pwd'
			 sh 'ls -l'			 
	            }
	      }
       }
       post {
          always {
		  sh 'pwd'
             junit 'user-register-gui-test/build/test-results/test/*.xml'
		  

        // publish html

        publishHTML target: [

            allowMissing: false,

            alwaysLinkToLastBuild: false,

            keepAll: true,

            reportDir: 'user-register-gui-test/build/reports/tests/test/',

            reportFiles: 'index.html',

            reportName: 'Report GUI Automation'

          ]
		  
          }
		 success {
		  sh 'echo "This will run only if successful"'
		  
		 }
		 failure {
		  sh 'echo "This will run only if failed"'
		  emailext attachmentsPattern: 'build/reports/tests/test/index.html', mimeType: 'text/html', body: '''${SCRIPT, template="groovy-html.template"}''', subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Failed", to: 'wara.rojas.u@gmail.com'
		 }
		 unstable {
		  sh 'echo "This will run only if the run was marked as unstable"'
          //emailext attachmentsPattern: 'build/reports/tests/test/index.html', mimeType: 'text/html', body: '''${SCRIPT, template="groovy-html.template"}''', subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Unstable", to: 'wara.rojas.u@gmail.com'		  
		 }		 
		 changed {
		  sh 'echo "This will run only if the state of the Pipeline has changed"'
          //emailext attachmentsPattern: 'build/reports/tests/test/index.html', mimeType: 'text/html', body: '''${SCRIPT, template="groovy-html.template"}''', subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Changed", to: 'wara.rojas.u@gmail.com'		  
		 }		  
       }	   
    }
  }
}
