const Mock = require('mockjs')

const Random = Mock.Random

let Result = {
    code: 200,
    msg: '操作成功',
    data: null
}

Mock.mock('/goods/info', 'get', () => {

    Result.data = {
        "goods": [{
                "id": 1,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
                "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
                "shop": "龙成商家",
                "price": 6882,
            }, {
                "id": 2,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2021/07/29/%E9%92%89%E9%92%89%E5%BC%80%E5%8F%91%E5%8A%A8%E7%9A%84%E5%89%AF%E6%9C%AC.gif/origine/eef8cd45-9603-431d-9363-8bc3c2871c6d",
                "describe": "钉钉开发丨企业微信支付宝抖音百度公众号智能小程序软件开发定制",
                "shop": "钉钉开发",
                "price": 6882.99,
            }, {
                "id": 3,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E7%84%A6%E7%82%B9%E5%9B%BE%E5%8C%85%E6%82%A8%E6%BB%A1%E6%84%8F.jpg/origine/25c3cdaf-5759-44ac-89f4-8031dfc8d6b8",
                "describe": "微信公众平台开发软件开发微信H5定制微信小程序开发网站建设保证完成",
                "shop": "浮莱科技",
                "price": 2345.34,
            }, {
                "id": 4,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2021/07/02/OA%E7%AE%A1%E7%90%86app.png/origine/af61be7e-2434-4ffd-ae9a-91dd4e16f030",
                "describe": "OA管理系统软件协同办公CRM内部管理钉钉APP定制开发设计",
                "shop": "七页科技",
                "price": 6884.00,
            }, {
                "id": 5,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E6%8A%96%E9%9F%B3%E6%B5%B7%E6%8A%A5-%E6%A8%AA%E7%89%884.4.jpg/origine/ee37b93f-503c-4c75-8ce5-d38b7e1ebe45",
                "describe": "聊天室社交网同城附近交友APP定制开发软件源码小程序系统成平 一年免费维护 保证完成",
                "shop": "视野科技",
                "price": 6882.00,
            }, {
                "id": 6,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E5%85%AC%E5%8F%B8logo.jpg/origine/0c3d4b9e-8c16-4994-aa4c-7d4c25e62b4a",
                "describe": "软件定制开发/应用程序/工具软件/数据库/电商软件/商城定制 保证完成",
                "shop": "未山科技",
                "price": 6882.00,
            }, {
                "id": 7,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2021/08/11/%E7%84%A6%E7%82%B92.jpg/origine/1c423c22-4e13-471d-b8a5-cbb0473de714",
                "describe": "APP开发商城定制作教育软件物联网系统社交成品物流app开发 保证完成",
                "shop": "千翼科技",
                "price": 6882.00,
            }, {
                "id": 8,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200618101831.png/origine/a8e3538b-6d17-479b-9c1b-5a1a9f8197cf",
                "describe": "同城APP定制开发java制作PHP软件设计成品app开发",
                "shop": "缘姐科技",
                "price": 6882.00,
            }, {
                "id": 9,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E6%8A%96%E9%9F%B3%E6%B5%B7%E6%8A%A5-%E6%A8%AA%E7%89%882.22.jpg/origine/9b4a1314-5c6d-4395-a239-02d7cbfdb054",
                "describe": "智能化家居app软件名片蓝牙手机办公展示系统定制硬件产品开发",
                "shop": "东方科技",
                "price": 6882.00,
            }, {
                "id": 10,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200909181930.jpg/origine/bd710174-fe1d-45ef-8cbb-2f56eef5dfb7",
                "describe": "洗浴足疗软件管理系统中医小儿推拿上门预约小程序APP开发定制 保证完成",
                "shop": "湿地科技",
                "price": 6882.00,
            }, {
                "id": 11,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2021/08/23/%E5%B0%8F%E7%A8%8B%E5%BA%8F%E5%8A%A8%E5%9B%BE.gif/origine/03876e25-d017-456c-b0bc-f85653cb1d92",
                "describe": "微信小程序定制开发小程序软件定制开发小程序商城H5微信开发",
                "shop": "百荣科技",
                "price": 6882.00,
            }, {
                "id": 12,
                "image": "https://homesitetask.zbjimg.com/homesite%2Ftask%2F2021%2F06%2F24%2F400.png%2Forigine%2Fb1c8fe20-6e26-47fe-8bf7-ede82d739594?imageView2/2/w/300/h/300",
                "describe": "【找对人-让体验设计更简单】产品/UI设计~百度设计师创业",
                "shop": "沪深科技",
                "price": 6882.00,
            }, {
                "id": 13,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E7%99%BE%E9%87%8C%E6%95%99%E8%82%B2%E5%B0%8F%E7%A8%8B%E5%BA%8F.jpg/origine/8be4449b-333b-4b2c-9dde-f2ed7212cf5e",
                "describe": "网页设计/网页ui/网站设计/网站制作/网站美工/网页制作、免费修改到满意为止 保证完成",
                "shop": "深度科技",
                "price": 6882.00,
            }, {
                "id": 14,
                "image": "https://img2.baidu.com/it/u=180134351,3383434236&fm=26&fmt=auto&gp=0.jpg",
                "describe": "ECstore/易开店模板 仿中酒网、酒仙网、购酒网、网酒网、12H出稿 免费修改到满意为止 保证完成",
                "shop": "迅捷创科",
                "price": 6882.00,
            }, {
                "id": 15,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E4%BA%94%E5%B9%B4%E5%93%81%E7%89%8C%E6%9C%8D%E5%8A%A1%E5%95%86.jpg/origine/5a93be85-b395-44b9-9404-ca1a3230f020",
                "describe": "网站建设网站开发网页设计响应式网站仿站外贸企业网站定制开发",
                "shop": "木兰传媒",
                "price": 6882.00,
            },
            {
                "id": 16,
                "image": "https://homesitetask.zbjimg.com/homesite/task/A%E5%8A%A0%E5%AD%A6%E9%99%A2_wps%E5%9B%BE%E7%89%87.jpg/origine/2db35fa7-7a15-4dd2-9a7a-f04182ef3dc6",
                "describe": "答题类APP开发在线视频学习软件开发题库软件开发网校定制开发 保证完成",
                "shop": "白狼教育",
                "price": 6882.10,
            }, {
                "id": 17,
                "image": "https://homesitetask.zbjimg.com/homesite/task/19.png/origine/a382ba02-00cc-4fa2-a36f-be34de7ab2e7",
                "describe": "ERP企业管理软件进销存CRM开发OA系统开发APP定制开发 保证完成",
                "shop": "闻峥文化",
                "price": 6882.20,
            }, {
                "id": 18,
                "image": "https://homesitetask.zbjimg.com/homesite/task/2021/03/09/%E6%9C%AA%E6%A0%87%E9%A2%98-1.jpg/origine/40508165-6dee-4150-9139-c8148e9841e0",
                "describe": "资产成本车间设备分销售考勤订单项目管理软件定制系统app开发",
                "shop": "页溪软件",
                "price": 6882.99,
            }, {
                "id": 19,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E6%8A%96%E9%9F%B3%E6%B5%B7%E6%8A%A5-%E6%A8%AA%E7%89%882.22.jpg/origine/ec74ddb7-c007-469c-ab44-29960a7b1a11",
                "describe": "软件开发定制价格商城制作行业外包众包管理网站公司小程序设计",
                "shop": "昵称科技",
                "price": 6882.00,
            }, {
                "id": 20,
                "image": "https://homesitetask.zbjimg.com/homesite/task/%E6%9C%AA%E6%A0%87%E9%A2%98-2.png/origine/4c64019a-1653-4702-b9e1-450b23215fac",
                "describe": "【公众平台开发】微商城官网支付砍价H5拼团软件定制开发建设",
                "shop": "伯伯科技",
                "price": 6882.00,
            },
            // {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }, {
            //     "id": 10,
            //     "image": "",
            //     "describe": "",
            //     "shop": "",
            //     "price": 6882.00,
            // }
        ],

    }
    return Result
})


Mock.mock('/order/info', 'get', () => {

    Result.data = {
        "order": [{
            "id": 1,
            "good_id": 1,
            "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
            "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
            "shop": "龙成商家",
            "price": 6882,
        }, {
            "id": 2,
            "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
            "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
            "shop": "龙成商家",
            "price": 6882,
        }, {
            "id": 3,
            "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
            "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
            "shop": "龙成商家",
            "price": 6882,
        }, {
            "id": 4,
            "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
            "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
            "shop": "龙成商家",
            "price": 6882,
        }, {
            "id": 5,
            "image": "https://homesitetask.zbjimg.com/homesite/task/2000%E5%85%83%E8%AF%A6%E6%83%85%E5%BA%97%E9%93%BA%E8%A3%85%E4%BF%AE_01.jpg/origine/579b8416-4758-4e12-9321-63b900650423",
            "describe": "企业官网网站建设H5网页设计制作前端公司定制开发响应式仿建站 免费修改到满意为止 一年免费维护 保证完成",
            "shop": "龙成商家",
            "price": 6882,
        }]
    }
    return Result
})


// mock('/login', 'post', () => {

//     // 无法在header中传入数jwt

//     // Result.code = 400
//     // Result.msg = "验证码错误"

//     return Result
// })
// mock('/sys/userInfo', 'get', () => {

//     Result.data = {
//         id: "1",
//         username: "test",
//         avatar: "https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg"
//     }

//     return Result
// })

// mock('/logout', 'post', () => {

//     return Result
// })

// // 获取用户菜单以及权限接口
// mock('/sys/menu/nav', 'get', () => {

//     let nav = [{
//             name: 'SysManga',
//             title: '系统管理',
//             icon: 'el-icon-s-operation',
//             component: '',
//             path: '',
//             children: [{
//                     name: 'SysUser',
//                     title: '用户管理',
//                     icon: 'el-icon-s-custom',
//                     path: '/sys/users',
//                     component: 'sys/User',
//                     children: []
//                 },
//                 {
//                     name: 'SysRole',
//                     title: '角色管理',
//                     icon: 'el-icon-rank',
//                     path: '/sys/roles',
//                     component: 'sys/Role',
//                     children: []
//                 },
//                 {
//                     name: 'SysMenu',
//                     title: '菜单管理',
//                     icon: 'el-icon-menu',
//                     path: '/sys/menus',
//                     component: 'sys/Menu',
//                     children: []
//                 }
//             ]
//         },
//         {
//             name: 'SysTools',
//             title: '系统工具',
//             icon: 'el-icon-s-tools',
//             path: '',
//             component: '',
//             children: [{
//                 name: 'SysDict',
//                 title: '数字字典',
//                 icon: 'el-icon-s-order',
//                 path: '/sys/dicts',
//                 component: '',
//                 children: []
//             }, ]
//         }
//     ]

//     let authoritys = ['sys:user:list', "sys:user:save", "sys:user:delete"]

//     Result.data = {
//         nav: nav,
//         authoritys: authoritys
//     }

//     return Result
// })

// //////////////// 菜单管理 ////////////////

// mock('/sys/menu/list', 'get', () => {
//     let menus = [{
//             "id": 1,
//             "created": "2021-01-15T18:58:18",
//             "updated": "2021-01-15T18:58:20",
//             "statu": 1,
//             "parentId": 0,
//             "name": "系统管理",
//             "path": "",
//             "perms": "sys:manage",
//             "component": "",
//             "type": 0,
//             "icon": "el-icon-s-operation",
//             "ordernum": 1,
//             "children": [{
//                     "id": 2,
//                     "created": "2021-01-15T19:03:45",
//                     "updated": "2021-01-15T19:03:48",
//                     "statu": 1,
//                     "parentId": 1,
//                     "name": "用户管理",
//                     "path": "/sys/users",
//                     "perms": "sys:user:list",
//                     "component": "sys/User",
//                     "type": 1,
//                     "icon": "el-icon-s-custom",
//                     "ordernum": 1,
//                     "children": [{
//                             "id": 9,
//                             "created": "2021-01-17T21:48:32",
//                             "updated": null,
//                             "statu": 1,
//                             "parentId": 2,
//                             "name": "添加用户",
//                             "path": null,
//                             "perms": "sys:user:save",
//                             "component": null,
//                             "type": 2,
//                             "icon": null,
//                             "ordernum": 1,
//                             "children": []
//                         },
//                         {
//                             "id": 10,
//                             "created": "2021-01-17T21:49:03",
//                             "updated": "2021-01-17T21:53:04",
//                             "statu": 1,
//                             "parentId": 2,
//                             "name": "修改用户",
//                             "path": null,
//                             "perms": "sys:user:update",
//                             "component": null,
//                             "type": 2,
//                             "icon": null,
//                             "ordernum": 2,
//                             "children": []
//                         },
//                         {
//                             "id": 11,
//                             "created": "2021-01-17T21:49:21",
//                             "updated": null,
//                             "statu": 1,
//                             "parentId": 2,
//                             "name": "删除用户",
//                             "path": null,
//                             "perms": "sys:user:delete",
//                             "component": null,
//                             "type": 2,
//                             "icon": null,
//                             "ordernum": 3,
//                             "children": []
//                         },
//                         {
//                             "id": 12,
//                             "created": "2021-01-17T21:49:58",
//                             "updated": null,
//                             "statu": 1,
//                             "parentId": 2,
//                             "name": "分配角色",
//                             "path": null,
//                             "perms": "sys:user:role",
//                             "component": null,
//                             "type": 2,
//                             "icon": null,
//                             "ordernum": 4,
//                             "children": []
//                         },
//                         {
//                             "id": 13,
//                             "created": "2021-01-17T21:50:36",
//                             "updated": null,
//                             "statu": 1,
//                             "parentId": 2,
//                             "name": "重置密码",
//                             "path": null,
//                             "perms": "sys:user:repass",
//                             "component": null,
//                             "type": 2,
//                             "icon": null,
//                             "ordernum": 5,
//                             "children": []
//                         }
//                     ]
//                 },
//                 {
//                     "id": 3,
//                     "created": "2021-01-15T19:03:45",
//                     "updated": "2021-01-15T19:03:48",
//                     "statu": 1,
//                     "parentId": 1,
//                     "name": "角色管理",
//                     "path": "/sys/roles",
//                     "perms": "sys:role:list",
//                     "component": "sys/Role",
//                     "type": 1,
//                     "icon": "el-icon-rank",
//                     "ordernum": 2,
//                     "children": []
//                 },

//             ]
//         },
//         {
//             "id": 5,
//             "created": "2021-01-15T19:06:11",
//             "updated": null,
//             "statu": 1,
//             "parentId": 0,
//             "name": "系统工具",
//             "path": "",
//             "perms": "sys:tools",
//             "component": null,
//             "type": 0,
//             "icon": "el-icon-s-tools",
//             "ordernum": 2,
//             "children": [{
//                 "id": 6,
//                 "created": "2021-01-15T19:07:18",
//                 "updated": "2021-01-18T16:32:13",
//                 "statu": 1,
//                 "parentId": 5,
//                 "name": "数字字典",
//                 "path": "/sys/dicts",
//                 "perms": "sys:dict:list",
//                 "component": "sys/Dict",
//                 "type": 1,
//                 "icon": "el-icon-s-order",
//                 "ordernum": 1,
//                 "children": []
//             }]
//         }
//     ]

//     Result.data = menus

//     return Result
// })

// mock(RegExp('/sys/menu/info/*'), 'get', () => {

//     Result.data = {
//         "id": 3,
//         "statu": 1,
//         "parentId": 1,
//         "name": "角色管理",
//         "path": "/sys/roles",
//         "perms": "sys:role:list",
//         "component": "sys/Role",
//         "type": 1,
//         "icon": "el-icon-rank",
//         "orderNum": 2,
//         "children": []
//     }

//     return Result
// })


// mock(RegExp('/sys/menu/*'), 'post', () => {

//     return Result
// })

// //////////////// 角色管理 ////////////////

// mock(RegExp('/sys/role/list*'), 'get', () => {

//     Result.data = {
//         "records": [{
//                 "id": 3,
//                 "created": "2021-01-04T10:09:14",
//                 "updated": "2021-01-30T08:19:52",
//                 "statu": 1,
//                 "name": "普通用户",
//                 "code": "normal",
//                 "remark": "只有基本查看功能",
//                 "menuIds": []
//             },
//             {
//                 "id": 6,
//                 "created": "2021-01-16T13:29:03",
//                 "updated": "2021-01-17T15:50:45",
//                 "statu": 1,
//                 "name": "超级管理员",
//                 "code": "admin",
//                 "remark": "系统默认最高权限，不可以编辑和任意修改",
//                 "menuIds": []
//             }
//         ],
//         "total": 2,
//         "size": 10,
//         "current": 1,
//         "orders": [],
//         "optimizeCountSql": true,
//         "hitCount": false,
//         "countId": null,
//         "maxLimit": null,
//         "searchCount": true,
//         "pages": 1
//     }

//     return Result

// })

// mock(RegExp('/sys/role/info/*'), 'get', () => {

//     Result.data = {
//         "id": 6,
//         "created": "2021-01-16T13:29:03",
//         "updated": "2021-01-17T15:50:45",
//         "statu": 1,
//         "name": "超级管理员",
//         "code": "admin",
//         "remark": "系统默认最高权限，不可以编辑和任意修改",
//         "menuIds": [3]
//     }

//     return Result
// })

// mock(RegExp('/sys/role/*'), 'post', () => {

//     return Result
// })

// //////////////// 用户管理 ////////////////

// mock(RegExp('/sys/user/list*'), 'get', () => {
//     Result.data = {
//         "records": [{
//                 "id": 1,
//                 "created": "2021-01-12T22:13:53",
//                 "updated": "2021-01-16T16:57:32",
//                 "statu": 1,
//                 "username": "admin",
//                 "password": "$2a$10$R7zegeWzOXPw871CmNuJ6upC0v8D373GuLuTw8jn6NET4BkPRZfgK",
//                 "avatar": "https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg",
//                 "email": "123@qq.com",
//                 "city": "广州",
//                 "lastLogin": "2020-12-30T08:38:37",
//                 "roles": [{
//                         "id": 6,
//                         "created": "2021-01-16T13:29:03",
//                         "updated": "2021-01-17T15:50:45",
//                         "statu": 1,
//                         "name": "超级管理员",
//                         "code": "admin",
//                         "remark": "系统默认最高权限，不可以编辑和任意修改",
//                         "menuIds": []
//                     },
//                     {
//                         "id": 3,
//                         "created": "2021-01-04T10:09:14",
//                         "updated": "2021-01-30T08:19:52",
//                         "statu": 1,
//                         "name": "普通用户",
//                         "code": "normal",
//                         "remark": "只有基本查看功能",
//                         "menuIds": []
//                     }
//                 ]
//             },
//             {
//                 "id": 2,
//                 "created": "2021-01-30T08:20:22",
//                 "updated": "2021-01-30T08:55:57",
//                 "statu": 1,
//                 "username": "test",
//                 "password": "$2a$10$0ilP4ZD1kLugYwLCs4pmb.ZT9cFqzOZTNaMiHxrBnVIQUGUwEvBIO",
//                 "avatar": "https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg",
//                 "email": "test@qq.com",
//                 "city": null,
//                 "lastLogin": null,
//                 "roles": [{
//                     "id": 3,
//                     "created": "2021-01-04T10:09:14",
//                     "updated": "2021-01-30T08:19:52",
//                     "statu": 1,
//                     "name": "普通用户",
//                     "code": "normal",
//                     "remark": "只有基本查看功能",
//                     "menuIds": []
//                 }]
//             }
//         ],
//         "total": 2,
//         "size": 10,
//         "current": 1,
//         "orders": [],
//         "optimizeCountSql": true,
//         "hitCount": false,
//         "countId": null,
//         "maxLimit": null,
//         "searchCount": true,
//         "pages": 1
//     }

//     return Result
// })


// mock(RegExp('/sys/user/*'), 'post', () => {
//     return Result
// })

// mock(RegExp('/sys/user/info/*'), 'get', () => {

//     Result.data = {
//         "id": 2,
//         "created": "2021-01-30T08:20:22",
//         "updated": "2021-01-30T08:55:57",
//         "statu": 1,
//         "username": "test",
//         "password": "$2a$10$0ilP4ZD1kLugYwLCs4pmb.ZT9cFqzOZTNaMiHxrBnVIQUGUwEvBIO",
//         "avatar": "https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg",
//         "email": "test@qq.com",
//         "city": null,
//         "lastLogin": null,
//         "roles": []
//     }
//     return Result
// })