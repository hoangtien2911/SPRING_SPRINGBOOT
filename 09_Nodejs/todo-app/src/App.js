import './App.css';
import TodoApp from './component/todo/TodoApp';

function App() {
  return (
    <div className="App">
      {/* <PlayWithProps property1="value1" property2="value2"/> */}
      {/* <Counter /> */}
      <TodoApp/>
    </div>
  );
}

// {property1="value1" property2="value2"}
// function PlayWithProps(properties) {
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
//   return (
//     <div>Props</div>
//   )
// }

// function PlayWithProps({property1, property2}) {
//   console.log(property1)
//   console.log(property2)
//   return (
//     <div>Props</div>
//   )
// }

export default App;
