def buildJar() {
    echo 'Building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t capeahhhhhhhhhh/demo-app:jmp-2.0 .'
        sh "echo \$PASS | docker login -u capeahhhhhhhhhh --password-stdin"
        sh 'docker push capeahhhhhhhhhh/demo-app:jmp-2.0'
    }
}


def deployApp() {
    echo 'Deploying the application...'
}

return this
