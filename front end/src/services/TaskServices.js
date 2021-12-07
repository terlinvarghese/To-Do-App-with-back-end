import axios from "axios";

class TaskServices{
 savetask(task){
     return axios.post("http://localhost:8080/save",task);
 }
 viewtask(){
     return axios.get("http://localhost:8080/view");
 }
 delete(id){
     return axios.post("http://localhost:8080/delete/"+id);
 }
 update(id){
     return axios.get("http://localhost:8080/update/"+id);
 }
}
export default new TaskServices();