import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TablePagination, TableRow } from "@mui/material";
import Grid2 from "@mui/material/Unstable_Grid2/Grid2";
import { useQuery } from "@tanstack/react-query";
import { getUserList } from "../../apis/user/UserApi";
import { useEffect, useState } from "react";

export default function UserList(){
    const [pageSize, setPageSize] = useState(10);
    const [pageNo, setPageNo] = useState(0);

    const rows = useQuery({queryKey:['user'], queryFn : ()=>getUserList(pageNo,pageSize)});

    useEffect(()=>{
        rows.refetch();
    },[pageNo,pageSize]);

    return (
        <Grid2>
            { rows.isLoading ? 
                ''
            :
                <Grid2>
                    <TableContainer component={Paper}>
                        <Table sx={{ minWidth: 650 }} aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>#</TableCell>
                                    <TableCell>ID</TableCell>
                                    <TableCell>NAME</TableCell>
                                </TableRow>
                            </TableHead>
                                <TableBody>
                                    {rows.data.data.list.map((row : any,i:number) => (
                                        <TableRow
                                            hover
                                            key={row.id}
                                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                        >
                                            <TableCell component="th" scope="row">
                                                {i+1}
                                            </TableCell>
                                            <TableCell>{row.id}</TableCell>
                                            <TableCell>{row.name}</TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            
                        </Table>
                    </TableContainer>
                    <TablePagination
                        rowsPerPageOptions={[5, 10, 25]}
                        component="div"
                        count={rows.data.data.count}
                        rowsPerPage={pageSize}
                        page={pageNo}
                        onPageChange={(e,newPage)=>{setPageNo(newPage)}}
                        onRowsPerPageChange={(e)=>{setPageSize(parseInt(e.target.value, 10))}}
                    />
                </Grid2>
            }
        </Grid2>
    )
}
