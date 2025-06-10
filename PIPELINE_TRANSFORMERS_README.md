# Reactive Pipeline Transformers - Advanced Exercises

This document describes the new advanced exercises (10-15) that have been added to the reactive Java workshop, focusing specifically on reactive pipeline transformers and advanced reactive programming patterns.

## Overview

The new exercises build upon the foundational concepts from exercises 1-9 and introduce more sophisticated reactive programming techniques. These exercises are designed to provide hands-on experience with complex pipeline transformations, time-based operations, stream combinations, and custom operators.

## New Data Sources

Several new data sources have been added to `ReactiveSources.java` to support the advanced exercises:

- `fastStringFlux()` - Quick emitting string stream
- `slowStringFlux()` - Slow emitting string stream  
- `evenNumbersFlux()` / `oddNumbersFlux()` - Filtered number streams
- `categoryFlux()` - Stream of categories for grouping exercises
- `temperatureFlux()` - Temperature readings for aggregation exercises
- `errorProneFlux()` - Stream that includes errors for error handling
- `extendedUserFlux()` - Larger user dataset with more football players
- `burstyNumbersFlux()` - Stream with varying emission rates
- `intervalStringFlux()` - Interval-based string emissions

## Exercise Descriptions

### Exercise 10: Complex Pipeline Transformations
**Focus**: Advanced transformation operators

**Key Concepts**:
- `flatMap` vs `concatMap` vs `switchMap` differences
- Nested stream handling and flattening
- Parallel processing with concurrency limits
- Complex pipeline chaining

**Learning Outcomes**:
- Understand when to use different flattening operators
- Handle nested reactive streams effectively
- Control concurrency in reactive pipelines
- Chain multiple transformations efficiently

### Exercise 11: Conditional and Dynamic Transformations  
**Focus**: Conditional operators and dynamic stream switching

**Key Concepts**:
- `takeWhile`, `skipWhile`, `takeUntil`, `skipUntil`
- Conditional transformations based on stream content
- Dynamic stream switching
- Conditional stream merging

**Learning Outcomes**:
- Apply conditional logic in reactive streams
- Dynamically switch between different processing paths
- Handle conditional stream termination
- Implement content-based stream routing

### Exercise 12: Time-based Transformations
**Focus**: Time-based operators and temporal stream processing

**Key Concepts**:
- `buffer` and `window` operations
- `sample`, `throttleFirst`, `throttleLast` (debounce)
- `delay` operations and timeout handling
- Interval-driven processing

**Learning Outcomes**:
- Group stream elements by time or count
- Control emission rates and handle bursty data
- Implement timeout and delay strategies
- Process time-series data effectively

### Exercise 13: Combining and Merging Streams
**Focus**: Stream combination operators

**Key Concepts**:
- `zip`, `zipWith` with custom combinators
- `merge`, `concat`, `combineLatest`
- `startWith`, `concatWith`
- Race conditions with `first`

**Learning Outcomes**:
- Combine multiple reactive streams effectively
- Understand timing implications of different combination operators
- Handle stream synchronization and coordination
- Implement complex stream orchestration patterns

### Exercise 14: Advanced Aggregation and Grouping
**Focus**: Complex aggregation and reduction operations

**Key Concepts**:
- `groupBy` with complex key functions
- `scan` for running totals and statistics
- `reduce` with complex accumulators
- Custom collectors and multi-level grouping

**Learning Outcomes**:
- Implement sophisticated data aggregation patterns
- Create running calculations and statistics
- Group and analyze streaming data
- Build custom aggregation logic

### Exercise 15: Custom Operators and Advanced Patterns
**Focus**: Creating custom operators and advanced reactive patterns

**Key Concepts**:
- Custom operators using `transform()` and `compose()`
- Advanced error handling patterns (circuit breaker, fallback chains)
- Performance optimization (caching, rate limiting)
- Metrics collection and parallel processing

**Learning Outcomes**:
- Create reusable custom operators
- Implement enterprise-grade error handling patterns
- Optimize reactive pipeline performance
- Build production-ready reactive applications

## Getting Started

1. **Prerequisites**: Complete exercises 1-9 to understand basic reactive concepts
2. **Approach**: Each exercise builds on previous concepts - work through them sequentially
3. **Practice**: Uncomment the TODO sections and implement the solutions
4. **Experimentation**: Modify the examples to explore different behaviors

## Key Learning Progression

```
Basic Reactive Concepts (Ex 1-9)
    ↓
Complex Transformations (Ex 10)
    ↓
Conditional Logic (Ex 11)
    ↓
Time-based Processing (Ex 12)
    ↓
Stream Combination (Ex 13)
    ↓
Advanced Aggregation (Ex 14)
    ↓
Custom Operators & Patterns (Ex 15)
```

## Running the Exercises

Each exercise can be run independently:

```bash
# Compile the project
mvn compile

# Run a specific exercise
mvn exec:java -Dexec.mainClass="io.javabrains.reactiveworkshop.Exercise10"
mvn exec:java -Dexec.mainClass="io.javabrains.reactiveworkshop.Exercise11"
# ... and so on
```

## Tips for Success

1. **Read the Comments**: Each exercise has detailed comments explaining the concepts
2. **Experiment**: Try modifying parameters and see how behavior changes
3. **Timing Matters**: Pay attention to timing in time-based exercises
4. **Error Handling**: Practice with the error scenarios to understand resilience patterns
5. **Performance**: Consider the performance implications of different operators

## Real-world Applications

These advanced patterns are commonly used in:
- **Microservices**: Stream processing and service coordination
- **IoT Applications**: Sensor data processing and aggregation
- **Financial Systems**: Real-time data analysis and risk management
- **Web Applications**: Real-time updates and event processing
- **Data Pipelines**: ETL operations and stream analytics

## Next Steps

After completing these exercises, consider exploring:
- Spring WebFlux for reactive web applications
- Reactor Kafka for stream processing
- R2DBC for reactive database access
- Project Reactor advanced features and operators

## Contributing

Feel free to suggest additional exercises or improvements to existing ones. The goal is to provide comprehensive coverage of reactive programming patterns that are useful in real-world applications.