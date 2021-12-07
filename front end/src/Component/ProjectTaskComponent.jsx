import React, {Component} from "react";
import TaskServices from "../services/TaskServices";


export class ProjectTaskComponent extends Component{
    constructor(props){
        super(props);
        this.state={
            task:''
        }
    }
    handletask=(event)=>{
        this.setState({
            task:event.target.value
        })
    }
    handlesubmit=(event)=>{
        let task={
            task:this.state.task
        }
        console.log(task);
        TaskServices.savetask(task).then((res)=>{
            console.log(res);
        })
        window.location.reload(false);
        
    }
    render(){
        return(
            <div className="container">
                <form>
                    <div className="form-group">
                    <h1>-------To Do App--------</h1>
                         <input type="text" placeholder="enter your task ✍️" className="form-control " value={this.state.task} onChange={this.handletask}></input>
                    </div><br></br>
                    <button type="button" onClick={this.handlesubmit} className="btn btn-success">+Add</button>
                </form>
            </div>
        );
    }
} 

export default ProjectTaskComponent;


