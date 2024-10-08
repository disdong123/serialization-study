### Architecture
#### Flow
```mermaid
flowchart LR
	user -->|dto| controller
	subgraph template-server
		requestDto[request dto]
		controller -->|request dto| service
	end
	
	subgraph template-domain
		domainObject[domain object]
		service -->|domain object| DomainService[domain service]
	end
	
	subgraph template-infrastructure:jpa
		config[jpa/querydsl configuration]
		entity
		DomainService -->|entity| repository
	end
	
	repository --> dbserver[db server]
	
	subgraph template-infrastructure:client
		clientConfig[rest-client configuration]
		clientDto[client dto]
		DomainService -->|client dto| client
	end
	
	client --> server[other server]
	
	subgraph template-infrastructure:redis
		cacheConfig[redis configuration]
		cacheDto[cache dto]
		DomainService -->|cache dto| cache
	end
	
	cache --> redisserver[redis server]
```


#### Implementation example
```mermaid
classDiagram
	PlainUser <|.. PlainUserImpl
	User <|.. UserImpl
	
	<<interface>>PlainUser
	<<interface>>User
	
	UserController <-- UserService
	UserService <-- UserManager
	UserManager <-- UserRepository
	UserRepository <|.. UserRepositoryImpl
	UserRepositoryImpl <-- UserJpaRepository
	
	UserManager ..> PlainUser
	UserManager ..> User 
	UserJpaRepository ..> UserEntity
	
	class UserManager {
		-userRepository: UserRepository
		+register(user: PlainUser) User
		+readOne(id: Long) User
	}

	
	class UserRepository {
		+findById(id: Long): User
		+save(user: PlainUser) User
	}
	<<interface>>UserRepository
	
	class UserRepositoryImpl {
		-userJpaRepository: UserJpaRepository
		+findById(id: Long) User
		+save(user: PlainUser) User
	}
	
	class UserJpaRepository {
		+save(user: UserEntity) UserEntity
	}
	
	namespace template-server {
		class UserController
		class UserService
	}
	
	namespace template-domain {
		class PlainUser
		class User
		class PlainUserImpl
		class UserImpl
		class UserManager
		class UserRepository
		class UserRepositoryImpl
	}
	
	namespace template-infrastructure-jpa {
		class UserJpaRepository
		class UserEntity
	}
```

#### Description