import logo from './logo.svg';
import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css'
import ProjectTaskComponent from './Component/ProjectTaskComponent';
import TaskView from './Component/TaskView';

function App() {
  return (
    <div className="App">
      <ProjectTaskComponent/>
      <TaskView/>
    </div>
  );
}


export default App;
