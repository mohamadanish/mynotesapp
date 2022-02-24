// Powered by Infostretch 

timestamps {

node () {

	stage ('mynotesapp - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/userBranch']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'caa78986-650f-4ad3-8efe-ac417f344590', url: 'https://github.com/mohamadanish/mynotesapp.git']]]) 
	}
	stage ('mynotesapp - Build') {
 			// Maven build step
	withMaven(maven: 'Maven 3.8.2') { 
 			if(isUnix()) {
 				sh "mvn -f mynotesapp/pom.xml clean install test " 
			} else { 
 				bat "mvn -f mynotesapp/pom.xml clean install test " 
			} 
 		} 
	}
}
}