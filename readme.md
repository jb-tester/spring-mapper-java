## MapStruct support in Spring: abstract class mapper with injected components and custom mappings

actually the `@Mapping` annotation attributes are not supported properly
also, the suggestion to convert to constructor injection is shown in mapper class with `@Autowired` field,
though the constructor injection causes the error on mapper implementation generating.
Also, no check for the correct (not private) field visibility is implemented.

### mapper that injects another mapper via `@Mapper#uses`
https://youtrack.jetbrains.com/issue/IDEA-372649/Spring-Mapstruct-for-mapper-that-injects-another-mapper-via-Mapperuses-no-indication-about-autowiring-is-shown-in-editor