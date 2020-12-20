Hello there!
This is the complete documentation of the "Non_Graded_Homework", where you can read about each package and its containment to understand how things are organized here

P.S. "Non_Graded_Homework" contains all the Homework and Non-Graded Homework solutions, except the most last Non-Graded Homework on Sets!

GenericsShapesBoard - this class class is meant to run and access all classes and functions that have Generic implementations
ShapesShapeBoard - this class class is meant to run and access all classes and functions that have Shape-based implementations

1. Utils package (Helper classes and functions)
   Here you can find 2 classes:
        1. ConsoleColors - this class only contains stuff for making the standard terminal output look more interesting and colorful
        2. CustomSortingAlgorithms - this class contains 2 Generic O(n^2) sorting algorithms, with both iterative and recursive versions



2. Shape_and_subclasses package (this is roughly the Homework 1)
   Here you can find 6 classes:
        1. (abstract) Shape
        2. Square (extends Shape)
        3. Circle (extends Shape)
        4. IsoscelesTriangle (extends Shape)
        5. Rectangle (extends Shape)
        6. GeometricFigures - this class is meant to run and test all classes and functions that extend from Shape

   And 3 interfaces:
        1. Describeable - to ensure that a class can be described (e.g. it has a name, area, height, etc. Something to let us understand what we are dealing with)
        2. Moveable - to ensure that all Shapes and classes that extend from it have the moveable() function
        3. Rotateable - to ensure that all Shapes and classes that extend from it have the rotateable() function



3. Shapes_ADTs package (all Shape-based Data Structures and their implementations are here)
   Contains 4 packages:
        1. ArrayList (the most basic ArrayList)
            Here you can find 2 classes:
                1. ShapesArrayList - The definition and implementation of the Shape-based ArrayLit
                2. MainForArrayList - this class is meant to run and test all the functions of the ShapesArrayList

        2. LinkedList (the most basic LinkedList)
            Here you can find 2 classes:
                1. ShapesLinkedList - The definition and implementation of the Shape-based LinkedList
                2. MainForLinkedList - this class is meant to run and test all the functions of the ShapesLinkedList

        3. Queue (the most basic Queue)
            Here you can find 5 classes:
                1. ShapesArrayQueue - The definition and implementation of the Shape-based Array-based Queue
                2. ShapesLinkedListQueue - The definition and implementation of the Shape-based LinkedList-based Queue
                3. MainForArrayQueue - this class is meant to run and test all the functions of the ShapesArrayQueue
                4. MainForLinkedListQueue - this class is meant to run and test all the functions of the ShapesLinkedListQueue
                5. QueueProcessor - this class is meant to run and test all the functions of both the ShapesLinkedListQueue and ShapesArrayQueue
            And 1 interface:
                1. ShapesQueue - all functions that a Shapes-based Queue must have

        4. Stack (the most basic Stack)
            Here you can find 2 classes:
                1. ShapesStack - The definition and implementation of the Shape-based Stack
                2. MainForStack - this class is meant to run and test all the functions of the ShapesStack

   And 2 interfaces:
        1. CustomShapesIterators - all the iterators that are meant to run over specific Shapes (e.g Circles, Rectangles, etc.) are declared here
        2. ShapesList - all functions that a Shapes-based List (ArrayList or LinkedList) must have



4. Generic_ADTs package (all Generic Data Structures and their implementations are here)
   Contains 3 packages:
        1. ArrayList (the most basic ArrayList)
            Here you can find 2 classes:
                1. GenericsArrayList - The definition and implementation of the Generic ArrayList
                2. MainForGenericsArrayList - this class is meant to run and test all the functions of the GenericsArrayList

        2. LinkedList (the most basic LinkedList)
            Here you can find 2 classes:
                1. GenericsLinkedList - The definition and implementation of the Generic LinkedList
                2. MainForGenericsLinkedList - this class is meant to run and test all the functions of the GenericsLinkedList

        3. Deque (the most basic Deque)
            Here you can find 4 classes:
                1. GenericsArrayListDeque - The definition and implementation of the Generic ArrayList-based Deque
                2. GenericsLinkedListDeque - The definition and implementation of the Generic LinkedList-based Deque
                3. MainForGenericsArrayListDeque - this class is meant to run and test all the functions of the GenericsArrayListDeque
                4. MainForGenericsLinkedListDeque - this class is meant to run and test all the functions of the GenericsLinkedListDeque
            And 1 interface:
                1. GenericsDeque - all functions that a Generic Deque must have

   And 2 interfaces:
        1. CustomGenericIterators - iterators that are meant to run from a specific index, or in a reverse order
        2. GenericsList - all functions that a Generic List (ArrayList or LinkedList) must have