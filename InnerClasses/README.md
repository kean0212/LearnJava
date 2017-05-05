## First Try
1. ***static nested class*** is the class shared by all outer instances. To access the inner class,
use `Outer.Inner`.
2. ***inner class*** is the non-static inner class. To instantiate an inner class object, use
`outerObject.new Inner()`.