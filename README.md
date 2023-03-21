# MVI-Reactive-Store

MVI stands for Model-View-Intent. It is an architectural pattern that utilizes unidirectional data flow. The data circulates between `Model` and `View` only in one direction - from `Model` to `View` and from `View` to `Model`.

<img src="mvi.jpg" alt="MVI" width="300"/>

### What is MVIKotlin
MVIKotlin is a Kotlin Multiplatform framework that provides a way of (not only) writing
shared code using MVI pattern. It also includes powerful debug tools like
logging and time travel. The main functionality of the framework does not depend on any
reactive nor coroutines library.  

<img src="mvikotlin.jpg" alt="MVIKotlin" width="600"/>


#### Responsibility
MVIKotlin does not bring or enforce any particular architecture. Its responsibility can be described as follows:

- To provide a single source of truth for `State` (the scope is not defined, it can be a whole app, a screen, a feature, or a part of a feature);
- To provide an abstraction for UI with efficient updates (however this is not obligatory, you can use whatever you want);
- To provide lifecycle aware connections (binding) between inputs and outputs (again this is not obligatory in any way).

Everything else is out of scope of the library, there are no definitions for "screens", "features", "modules", etc. Also, no particular reactive framework is enforced/exposed. This gives a lot of flexibility:

- MVIKotlin can be introduced incrementally (e.g. you can start using it in a small feature and then expand gradually);
- You can use/experiment with different architectures, approaches and/or libraries for navigation, UI, modularization, etc;
- Use whatever reactive framework you like or don't use it at all.
