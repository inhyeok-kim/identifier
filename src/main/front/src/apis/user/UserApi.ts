import axios from "axios";

export const getUserList = async(pageNo:number,pageSize:number) =>{
    const res = await axios.get(`/api/user/search?pageNo=${pageNo}&pageSize=${pageSize}`);
    return res.data;
} 