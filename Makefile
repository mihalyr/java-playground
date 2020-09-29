.PHONY: build guard build-notest compile
.SUFFIXES:

build: # full build
	@./gradlew build

build-notest: # build without tests
	@./gradlew build -x test

guard: # continuous test execution
	@./gradlew test --continuous

compile: # alias for compileJava
	@./gradlew compileJava

%: # any gradle task
	@./gradlew $@
