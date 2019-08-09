# dropwizard-template

[![Actions Status](https://wdp9fww0r9.execute-api.us-west-2.amazonaws.com/production/badge/abatilo/dropwizard-template?style=flat)](https://wdp9fww0r9.execute-api.us-west-2.amazonaws.com/production/badge/abatilo/dropwizard-template?branch=master)

I like using Dropwizard as my http server as choice. I use it a lot and every
time, I copy common files from other projects. I figure I might as well make a
template for getting started.

## Getting Started

Run `make help` to get started:
```
⇒  make help
help                           View help information
test                           Runs tests
run                            Run the application locally
build                          Builds a container
clean                          Deletes used containers and volumes
```

## Operations

### Healthchecks
Healthchecks are available at:
```
curl http://localhost:8081/healthcheck
```

### Metrics
Prometheus format metrics are available at:
```
curl http://localhost:8081/metrics-text
```

**Note**: The metrics server is running on a different servlet than the main application
to mitigate any interference.

## Built With

* [Dropwizard](http://www.dropwizard.io/1.1.4/docs/) - The web framework used
* [Guava](https://github.com/google/guava/wiki/Release23) - Utility functions
* [Lombok](https://projectlombok.org/) - Annotations for less boilerplate code

## Contributing

Fork the project and submit a PR and one of the maintainers will be in touch.

## Authors

* Aaron Batilo - Developer / maintainer - [abatilo](https://github.com/abatilo)

See also the list of [contributors](https://github.com/abatilo/dropwizard-template/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
