
# To start the docker -> postgres for the first time
# It creates a container named bookstore-app
docker run --name bookstore-app -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres

# For next times just start the already created container to retain last saved data
docker start bookstore-app