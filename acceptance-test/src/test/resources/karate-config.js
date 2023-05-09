function fn() {
    var env = karate.env; // get java system property 'karate.env' in  build.gradle
    karate.log('karate.env system property was:', env);
    karate.configure('ssl', true);
    karate.configure('logPrettyResponse', false)

    if (!env) {
        env = 'local'; // a custom 'intelligent' default
    }

    var config = { // base config JSON

        authKey: '#{AUTHKEY}#',
        apiKey: 'api-key',
        key: 'API Key'
    };

    if (env == 'dev') {
        config.authKey
        config.urlBase = 'https://financiacion-int-dev.apps.ambientesbc.com/saf';
    } else if (env == 'cer') {
        config.authKey
        config.urlBase = 'https://financiacion-int-qa.apps.ambientesbc.com/saf';
    } else if (env == 'local') {
        config.authKey
        config.urlBase = 'https://financiacion-int-dev.apps.ambientesbc.com/saf';

    }

    karate.configure('headers', {Authorization: config.key, apiKey: config.authKey})
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);

    return config;
}