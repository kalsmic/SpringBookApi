
## configure postgres Db with docker
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
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres docker run --rm --name pg-docker -e POSTGRES_USER=pg_user POSTGRES_PASSWORD=pg_password POSTGRES_DB=book_db -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
```

- To inspect the container with psql
```bash
docker exec -it container_id psql -h localhost -U pg_user -d book_db
```


## Resources
[PostgreSQL - Psql Comands](https://www.geeksforgeeks.org/postgresql-psql-commands/)