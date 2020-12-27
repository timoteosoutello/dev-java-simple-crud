docker stop "$1" || true

docker rm -f $1 || true

docker build --no-cache -t $1 .

docker run -d --restart always -p $2:8080 -e SPRING_PROFILES_ACTIVE=$3 -e JASYPT_ENCRYPTOR_PASSWORD=$4 --name $1 -t $1