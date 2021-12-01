CREATE TABLE IF NOT EXISTS PUBLIC.host_info (
                                  id    SERIAL PRIMARY KEY,
                                  hostname   VARCHAR UNIQUE NOT NULL,
                                  cpu_number INTEGER NOT NULL,
                                  cpu_architecture VARCHAR NOT NULL,
                                  cpu_model VARCHAR NOT NULL,
                                  cpu_mhz REAL NOT NULL,
                                  L2_cache INTEGER NOT NULL,
                                  total_mem INTEGER NOT NULL,
                                  timestamp TIMESTAMP NOT NULL);

CREATE TABLE IF NOT EXISTS PUBLIC.host_usage (
                                  id    SERIAL PRIMARY KEY,
                                  hostname   VARCHAR UNIQUE NOT NULL,
                                  cpu_number INTEGER NOT NULL,
                                  cpu_architecture VARCHAR NOT NULL,
                                  cpu_model VARCHAR NOT NULL,
                                  cpu_mhz REAL NOT NULL,
                                  L2_cache INTEGER NOT NULL,
                                  total_mem INTEGER NOT NULL,
                                  'timestamp' TIMESTAMP NOT NULL);
