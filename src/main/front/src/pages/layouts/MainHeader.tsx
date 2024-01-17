import { Logout } from "@mui/icons-material";
import { Avatar, IconButton, ListItemIcon, Menu, MenuItem } from "@mui/material";
import Grid2 from "@mui/material/Unstable_Grid2/Grid2";
import { grey } from "@mui/material/colors";
import { useState } from "react";

export default function MainHeader(){

    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
    const open = Boolean(anchorEl);
    const handleClick = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <Grid2 
                    width={'100%'}    
                    height={'48px'}
                    bgcolor={grey[100]}
                    padding={1}
                    container
                    justifyContent={"space-between"}
                >
            <Grid2>
                header
            </Grid2>
            <Grid2
                container
                alignItems={"center"}
                paddingRight={2}
            >
                <IconButton
                    onClick={handleClick}
                    size="small"
                    sx={{ ml: 2 }}
                >
                    <Avatar src="/broken-image.jpg" sx={{width:24,height:24}} />
                </IconButton>
                <Menu
                    anchorEl={anchorEl}
                    id="account-menu"
                    open={open}
                    onClose={handleClose}
                    onClick={handleClose}
                    PaperProps={{
                        elevation: 0,
                        sx: {
                                overflow: 'visible',
                                filter: 'drop-shadow(0px 2px 8px rgba(0,0,0,0.32))',
                                mt: 1.5,
                                '& .MuiAvatar-root': {
                                width: 32,
                                height: 32,
                                ml: -0.5,
                                mr: 1,
                            },
                            '&::before': {
                                content: '""',
                                display: 'block',
                                position: 'absolute',
                                top: 0,
                                right: 14,
                                width: 10,
                                height: 10,
                                bgcolor: 'background.paper',
                                transform: 'translateY(-50%) rotate(45deg)',
                                zIndex: 0,
                            },
                        },
                    }}
                    transformOrigin={{ horizontal: 'right', vertical: 'top' }}
                    anchorOrigin={{ horizontal: 'right', vertical: 'bottom' }}
                >
                    <MenuItem onClick={handleClose} dense>
                        Profile
                    </MenuItem>
                    {/* <Divider /> */}
                    <MenuItem onClick={()=>{
                            handleClose();
                            window.location.replace('/logout');
                        }}
                        dense
                    >
                        <ListItemIcon>
                            <Logout fontSize="small" />
                        </ListItemIcon>
                        Logout
                    </MenuItem>
                </Menu>
            </Grid2>
        </Grid2>
    )
}