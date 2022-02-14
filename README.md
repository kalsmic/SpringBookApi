
## configure postgres Db with docker
### Alternative 1: Using Docker directly
- Pull an image from docker 
```bash
docker pull postgres
```
- Create a directory to serve as a local mount point for Postgres Data Files

```bash
mkdir -p $HOME/docker/volumes/postgres 
```
- Run the postgres container
```bash
docker run -d --rm \
    --name book-postgres \
    -e POSTGRES_USER=admin \
    -e POSTGRES_PASSWORD=pg_password \
    -e POSTGRES_DB=book_db \
    -p 5432:5432 \
    -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
```
-  `--rm`  Automatically remove the container and it’s associated file system upon exit.
- `-v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres` -  This ensures that postgres data persists even after the container is removed.


### Alternative 2: using docker compose
 ```bash
 docker-compose up -d # run this command to start postgres
 ```

### Inspecting the container with psql
```bash 
docker container ls # run this to get the container id
```

```bash
docker exec -it CONTAINER_ID psql -h localhost -U admin -d book_db # replace the CONTAINER_ID to inspect the postgres container using psql
```


## Resources
- [PostgreSQL - Psql Comands](https://www.geeksforgeeks.org/postgresql-psql-commands/)
- [How to setup Postgres using a docker image](https://hackernoon.com/dont-install-postgres-docker-pull-postgres-bee20e200198)