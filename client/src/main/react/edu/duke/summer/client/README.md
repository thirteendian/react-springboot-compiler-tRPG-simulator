# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more
information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will
remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right
into your project so you have full control over them. All of the commands except `eject` will still work, but they will
point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you
shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't
customize it when you are ready for it.

## Learn More

You can learn more in
the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved
here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved
here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved
here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved
here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved
here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved
here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)

### Few react examples:

#### 1. Auto Generated List

In react, normally considering list as two different component:

1. Item that is each entry
2. List that contains all Item

List subscribes outside state changing, and use state to update Item.

In Item:
```jsx
//handle the change of this item
handleOnChange=(itemID)=>{
    return (event)=>{
        
    }
}
return(
    ...
        <Input onChange(this.handleOnChange(itemID) />
    ...
)
```
In List:

```jsx
return (
    <ul>
        {
            this.props.listToShow(//listToShow is a list of object
                each => { //each is an object
                    return <Item context={...each}/>
                }
            )
        }

    </ul>
)
```

To add new object into object list, first method is "Lifting State Up".
In React single direct data binding,
**where the data is stored, where to define the 
method to update the data.**
In common parents, 
```jsx
...
//received from server
//add uuid if no id is comming from server
const object = {id:nanoid(),...object}
...
//update function of each object
updateItem = (id, done)=>{
    const {objectList} = this.state
    objectList.map((eachObject)=>{
        ...
    })
}
addObject = (object)=>{
    //Fetch original list
    const {originalList} = this.state;
    //Add new object to the list
    const newList = [object,...originalList]
    //update state
    this.setState({objectList:newList})
}
```
Second method use publish subscribe method in `PubSub.js` to communicate between components:
```jsx
//...in subscriber

import PubSub from 'pubsub-js'
componentDidMount(){
    var token = PubSub.subscribe("Endpoint",callFunction);
}

callFunction =(message,data)=>{
    //the message is the subscribe Endpoint
    //the data is the data been published by Endpoint
}

//When publisher publish on Endpoint
// the subscriber will call callFunction
//The token can be unsubscribed my token
componentWillUnmount(){
    PubSub.unsubscribe(token)
}
//...in publisher


//...in publisher:
//initilize state
PubSub.publish("EndPoint",{...})
//get data from server:
axios.get("url").then{
    response=>{
        PubSub.publish("EndPoint",{...,data:response.data.theObject})
    },
    error=>{
        PubSub.pubslish("EndPoint",{...,error:error.message})
    }
}


```
