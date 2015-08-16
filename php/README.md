# PHP Solutions to [Cracking The Coding Interview 6th Ed.](http://www.crackingthecodinginterview.com/)

Dependencies: [PHPUnit](https://phpunit.de/), which can be installed either [standalone](https://phpunit.de/manual/current/en/installation.html#installation.phar) or via [Composer](https://phpunit.de/manual/current/en/installation.html#installation.composer) ([`composer.json`](composer.json) supplied).

## Running Unit Tests

### Using PHPUnit installed via Composer (recommended)

First install PHPUnit (you only need to do this once)

    composer install

Then you can run the unit tests using the PHPUnit that composer installed

    ./vendor/bin/phpunit test

### Using Standalone PHPUnit

Assuming the `phpunit` binary is in your user's path, simply run

    phpunit test


