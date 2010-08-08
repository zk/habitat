# habitat

Enviroment-based configuration for Clojure projects.

## Leiningen
    [habitat "0.1.0-SNAPSHOT"]

## Getting Started

1. Create a new clojure project.
2. Add habitat to your project management file (project.clj / pom.xml / whatever).
3. Create a habitat directory in your resources directory.
4. Create a default.clj in your resources/habitat directory:
    ;; Example default.clj
    {:my-config-item "hello world from default"}
5. Create a dev.clj in your resources/habitat directory:
    ;; dev.clj
    {:my-config-item :hello-world-from-dev}
6. Start a repl and run:
    user=> (require 'habitat)
    user=> (habitat/habitat)   ;defaults to :dev enviroment
    {:my-config-item :hello-world-from-dev}

7. To set the enviroment at runtime:
    ;; other-env.clj
	{:my-config-item :other-env}
	
	% export JAVA_OPTS="-Dhabitat.env=other-env"; lein repl
	user=> (require 'habitat)
	user=> (habitat/habitat)
	{:my-config-item :other-env}

## License

Copyright (C) 2010 Zachary Kim

Distributed under the Eclipse Public License v1.0 [http://www.eclipse.org/legal/epl-v10.html](http://www.eclipse.org/legal/epl-v10.html)