import { Divider,List, ListItem, ListItemButton, ListItemText, Typography } from "@mui/material";
import Grid2 from "@mui/material/Unstable_Grid2/Grid2";
import { grey } from "@mui/material/colors";
import { useEffect } from "react";
import { Outlet, useLocation, useNavigate } from "react-router-dom";
import MainHeader from "./MainHeader";

export default function MainLayout(){
    const navigate = useNavigate();
    const location = useLocation();
    useEffect(()=>{
        console.log(location.pathname);
    },[location]);
    

    return (
        <Grid2
            container
            width={'100vw'}
        >
            <Grid2
                width={200}
                height={'100vh'}
            >
                <Grid2
                    bgcolor={grey['100']}
                    paddingX={2}
                    paddingY={1}
                >
                    <Typography variant="h6" fontFamily={"sans-serif"}>
                        Identifier
                    </Typography>
                </Grid2>
                <Grid2>
                    <List
                        disablePadding
                    >
                        <Divider/>
                        <ListItem disablePadding dense>
                            <ListItemButton selected={location.pathname==='/home'} onClick={()=>{navigate("/home")}}>
                                <ListItemText primary="홈" />
                            </ListItemButton>
                        </ListItem>
                        <Divider/>
                        <ListItem disablePadding  dense>
                            <ListItemButton selected={location.pathname==='/user/list'} onClick={()=>{navigate("/user/list")}}>
                                <ListItemText primary="사용자 관리" />
                            </ListItemButton>
                        </ListItem>
                        <Divider/>
                    </List>
                </Grid2>
            </Grid2>
            <Divider orientation="vertical" flexItem />
            <Grid2
                width={"calc(100% - 201px)"}
            >
                <MainHeader />
                <Divider/>
                <Grid2
                    padding={1}
                >
                    <Outlet />
                </Grid2>

            </Grid2>
        </Grid2>
    )
}