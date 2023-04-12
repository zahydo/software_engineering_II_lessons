# Template Method

## Description

The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm in a superclass, while allowing subclasses to override specific steps of the algorithm without changing its structure. This pattern promotes code reuse by providing a common structure for related algorithms while allowing their implementations to vary.

## Problem

In software development, we often encounter situations where multiple algorithms perform similar tasks, but with slight variations in their implementation. For instance, suppose we have several payment processing algorithms that use different payment gateways and authentication methods. In this case, we might end up duplicating code and violating the DRY (Don't Repeat Yourself) principle, which can lead to maintenance issues and bugs.

## Solution

The Template Method pattern provides a solution by defining a common algorithm structure in a superclass, while allowing subclasses to implement specific steps of the algorithm. The superclass acts as a template that provides a framework for the algorithm, while the subclasses provide the implementation details.

The template method consists of several steps that are executed in a specific order. The superclass defines the overall structure of the algorithm, including the steps that cannot be changed by the subclasses. However, it also provides hooks, which are methods that can be overridden by the subclasses to customize specific steps of the algorithm.

### Structure

The following diagram describes the pattern using the example as analogy

<p align="center">
    <img src="./diagrams/TemplateMethod.svg"/>
</p>






