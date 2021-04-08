<h1>GuestBookService</h1>


For the endpoints on this API, you can use the REST Docs add-on url: /docs/index.html

---

<h2>Information</h2>

This is a simple Guest Book API that allows users to put not only their name in but leave a comment for others to see.

---

To run the guestbook service within Docker that uses a Docker postgres, run the follow commands:

```
docker build -t guestbook:dev .

docker pull postgres

docker network create --driver bridge guestbook-network

docker run --name guestbook-postgres --network guestbook-network -e POSTGRES_PASSWORD=open_admin -e POSTGRES_DB=postgres -e SPRING_PROFILES_ACTIVE=local -d postgres

docker run -d -p 1000:8080 --name guestbook --network guestbook-network -e PORT=8080 -e "SPRING_PROFILES_ACTIVE=local" --rm guestbook:dev
```

```
docker build -t guestbook:dev . && docker pull postgres && docker network create --driver bridge guestbook-network && docker run --name guestbook-postgres --network guestbook-network -e POSTGRES_PASSWORD=open_admin -e POSTGRES_DB=postgres -e SPRING_PROFILES_ACTIVE=local -d postgres && docker run -d -p 1000:8080 --name guestbook --network guestbook-network -e PORT=8080 -e "SPRING_PROFILES_ACTIVE=local" --rm guestbook:dev 

```

To verify all is connected, can utilize the following commands to login into the postgres container and check the tables are there.

```
docker exec -it guestbook-postgres /bin/bash

psql -U postgres

\dt

```

You should see the results below:

 Schema |      Name      | Type  |  Owner   
--------:|----------------:|-------:|----------
 public | visitor_entity | table | postgres

To run the guestbook service within Heroku
```
1. Create a new application in Heroku
2. Back on the Heroku web dashboard for your app, go to the "Deploy" tab. Select the Container Registry deployment option and follow instructions.
      heroku login
      heroku git:remote -a
      heroku container:login
      heroku container:push web
      heroku container:release web
```