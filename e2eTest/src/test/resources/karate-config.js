function fn() {

  var env = karate.env; // get java system property 'karate.env' in  build.gradle
  karate.log('karate.env system property was:', env);
  karate.configure ('ssl', true);


  if (!env) {
    env = 'local'; // a custom 'intelligent' default
  }

  var config = { // base config JSON
      authkey: 'e19554b1-8c29-4e36-97b2-c3410e0ef573',
      key: 'API Key'
  };

  if (env == 'dev') {
    config.urlBase = 'https://#{gateway-host}#/saf';
    config.configbd = { username: '#{E2E-userBD}#', password: '#{E2E-passBD}#', url: 'jdbc:postgresql://nu0139001-saf-qa-clusteraurorapostgres.cluster-cpugxbn8bswu.us-east-1.rds.amazonaws.com:5432/SAFQCD?currentSchema=schsaf', driverClassName: 'org.postgresql.Driver' }

  } else if (env == 'cer') {
    config.authkey
    config.urlBase = 'https://#{gateway-host}#/saf';
    config.configbd = { username: '#{E2E-userBD}#', password: '#{E2E-passBD}#', url: 'jdbc:postgresql://nu0139001-saf-qa-clusteraurorapostgres.cluster-cpugxbn8bswu.us-east-1.rds.amazonaws.com:5432/SAFQCD?currentSchema=schsaf', driverClassName: 'org.postgresql.Driver' }

  } else if (env == 'local') {
    config.authkey
    config.urlBase = 'https://financiacion-int-qa.apps.ambientesbc.com/saf';
    config.configbd = { username: 'qasaftest', password: '1CHXXCk&#hV&', url: 'jdbc:postgresql://nu0139001-saf-qa-clusteraurorapostgres.cluster-cpugxbn8bswu.us-east-1.rds.amazonaws.com:5432/SAFQCD?currentSchema=schsaf', driverClassName: 'org.postgresql.Driver' }

  }
  karate.configure('headers', {Authorization: config.key, 'api-key': config.authkey})
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  return config;
}