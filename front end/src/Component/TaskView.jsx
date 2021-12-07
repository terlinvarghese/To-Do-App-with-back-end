import React,{Component} from "react";
import TaskServices from "../services/TaskServices";
export class TaskView extends Component{
    constructor(props){
        super(props);
        this.state={
            task:[]
        }
    }
    handledelete(id){
        console.log("Nice");
        TaskServices.delete(id).then((res)=>{
                   console.log(res);
            })
            window.location.reload(false);
        
    }
    componentDidMount(){
        console.log("hiiii view");
        TaskServices.viewtask().then((res)=>{
            console.log(res);
            this.setState({
                task:res.data
            })
        })
        console.log(this.state.task);
    }
    handlechange(id){
        console.log("checkbox")
      TaskServices.update(id).then((res)=>{
          console.log(res);

      })
      window.location.reload(false);
    }
    
  
  render(){
      return(
          <div className="container">
              <table>
                {
                    this.state.task.map(
                        t=>
                        <tr>
                            {t.status==="completed"?(<td><span>&#x2713;</span></td>):
                            (           <td>
                                <input type="radio" onClick={()=>this.handlechange(t.id)} />
                            </td>)}
                           
                           <td> <span style={{textDecoration:t.status==="completed"?"line-through":""}}>{t.task}             </span> </td>
                           <td> <button type="button" className="btn btn-danger" onClick={()=>this.handledelete(t.id)}>                              ❌    </button></td>
                        </tr>
                    )
                }
              </table>
          </div>
      )
  }
}
export default TaskView;