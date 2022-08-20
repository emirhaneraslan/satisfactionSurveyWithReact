import './UserList.css'
import AdminNavbar from '../../components/AdminNavbar/Navbar'
import ToggleButton from '../../components/ToggleButton/ToggleButton'
import { useEffect } from 'react'
import { useState } from 'react'



const UserList = () =>{


    const [users,setUsers] = useState([])

    useEffect(()=> {
        var axios = require('axios');

var config = {
  method: 'get',
  url: 'http://localhost:8080/api/user/findAll',
  headers: { }
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
  setUsers(response.data)
  
})
.catch(function (error) {
  console.log(error);
});

      },[])

      useEffect(()=>{
        console.log("değişti");
      },[users])

      const onClickButton = (item) => {
        console.log(item);
        console.log(!item.active);
        var axios = require('axios');
        var data = JSON.stringify({
        "userName": `${item.userName}`,
        "userSurname": `${item.userSurname}`,
        "userEmail": `${item.userEmail}`,
        "userAdress": `${item.userAdress}`,
        "active": !item.active
        });

        var config = {
        method: 'put',
        url: `http://localhost:8080/api/user/update/${item.userId}`,
        headers: { 
        'Content-Type': 'application/json'
        },
        data : data
        };

        axios(config)
        .then(function (response) {  
            const arr = [...users]
            arr[item.userId-1].active=!item.active;
            setUsers(arr)       
        })
        .catch(function (error) {
        console.log(error);
        });

      }

    return(
        <>
        <AdminNavbar/>

        <div className="container">
            <div className="row">
                <div className="col"></div>
                <div className="col-11">
                <table className="content-table">
  <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Surname</th>
      <th>E-mail</th>
      <th>Active</th>
    </tr>
  </thead>
  <tbody>
    {users.map((item,i)=>{
        return(
            <>
            <tr>
            <td>{item.userId}</td>
            <td>{item.userName}</td>
            <td>{item.userSurname}</td>
            <td>{item.userEmail}</td>
            <td><ToggleButton active={item.active} onClick={(e)=>{
                onClickButton(item)
            }}/></td>
    </tr>
            </>
        )
    })}
  </tbody>
</table>
                </div>
                <div className="col"></div>
            </div>
        </div>
        </>
    )
}

export default UserList