# Pokedex API Project
This is a simple api server that exposes APIs to retrieve pokemons information.

## How to Run the Application
### Prerequisites
Ensure you have the following installed:
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)
### Steps to Install and Run
*note:* in some of these steps you may need to be the root user.
1. Clone the Repository
```shell
git clone https://github.com/Aniello98/Pokedex.git
```
2. Navigate to the project directory
```sh
cd Pokedex
```
3. start docker
```shell
dockerd
```
4. build the docker image
```shell
docker build -t pokemon-api-server
```
5. run the docker container
```shell
docker run -p 8080:8080 pokemon-api-server
```
6. enjoy the APIs at `localhost:8080` :)

## What I Would Have Done in a Production Environment
### 1. API Versioning
I would add a version to the API path (e.g., /v1/). This allows for the implementation of a new version (e.g., /v2/) if future breaking changes are needed.
### 2. Timeout On API Calls
To prevent thread pool saturation and avoid infinite waiting times that harm user experience, I would configure a timeout for external API calls. This ensures the thread is interrupted if the external server takes too long to respond.
### 3. Thread Pool Tuning
I would tune the thread pool size based on the hardware resources where the project is deployed, ensuring optimal handling of requests.
### 4. Load Testing Before Production Release
A load test would measure the service’s robustness under high request loads. For highly demanded APIs, this test ensures the service behaves as expected under stress.