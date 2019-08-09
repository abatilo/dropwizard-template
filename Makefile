SHELL := /bin/bash

PROJECT_NAME = dropwizard-template
CONTAINER_NAME = abatilo/$(PROJECT_NAME)

.PHONY: help
help: ## View help information
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: test
test: ## Runs tests
	docker run \
		--interactive \
		--tty \
		--mount type=bind,src=`pwd`,dst=/src \
		--mount type=volume,src=$(PROJECT_NAME),dst=/root/.gradle \
		--workdir /src \
		--rm \
		openjdk:8 ./gradlew test

.PHONY: run
run: ## Run the application locally
	docker run \
		--interactive \
		--tty \
		--publish 8080-8081:8080-8081 \
		--mount type=bind,src=`pwd`,dst=/src \
		--mount type=volume,src=$(PROJECT_NAME),dst=/root/.gradle \
		--workdir /src \
		--rm \
		openjdk:8 ./gradlew run

.PHONY: build
build: ## Builds a container
	docker build \
		--tag $(CONTAINER_NAME) \
		.

.PHONY: clean
clean: ## Deletes used containers and volumes
	docker rmi --force $(CONTAINER_NAME)
	docker volume rm --force $(PROJECT_NAME)
