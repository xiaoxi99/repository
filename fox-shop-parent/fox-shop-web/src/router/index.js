import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: {title: '自述文件'},
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
                    meta: {title: '系统首页'}
                },
                {
                    path: '/icon',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Icon.vue'),
                    meta: {title: '自定义图标'}
                },
                {
                    path: '/ProductClassify',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/ProductClassify.vue'),
                    meta: {title: '商品分类'}
                },
                {
                    path: '/Product',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/product/Product.vue'),
                    meta: {title: '商品管理'}
                },
                {
                    path: '/ProductAdd',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/product/ProductAdd.vue'),
                    meta: {title: '商品维护'}
                },
                {
                    path: '/ProductUpdate',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/product/ProductUpdate.vue'),
                    meta: {title: '商品修改'}
                },
                {
                    path: '/ProductAttribute',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/ProductAttribute.vue'),
                    meta: {title: '商品类型'},
                },
                {
                    path: '/ProductBrand',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/pms/ProductBrand.vue'),
                    meta: {title: '商品类型'},
                },
                {
                    path: '/AttributeList',
                    component: () => import('../components/page/pms/AttributeList.vue'),
                    meta: {title: '属性列表'},
                },
                {
                    path: '/admin',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/Admin.vue'),
                    meta: {title: '用户列表'}
                },
                {
                    path: '/role',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/Role.vue'),
                    meta: {title: '角色列表'}
                },
                {
                    path: '/menu',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/Menu.vue'),
                    meta: {title: '菜单列表'}
                },
                {
                    path: '/resource',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/Resource.vue'),
                    meta: {title: '资源列表'}
                },
                {
                    path: '/resourceCategory',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/ResourceCategory.vue'),
                    meta: {title: '资源列表'}
                },
                {
                    path: '/menuTree',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/MenuTree.vue'),
                    meta: {title: '资源列表'}
                },
                {
                    path: '/resourceCategoryTree',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/ums/ResourceCategoryTree.vue'),
                    meta: {title: '资源列表'}
                },
                {
                    // vue-schart组件
                    path: '/charts',
                    component: () => import(/* webpackChunkName: "chart" */ '../components/page/BaseCharts.vue'),
                    meta: {title: 'schart图表'}
                },
                {
                    // 拖拽列表组件
                    path: '/drag',
                    component: () => import(/* webpackChunkName: "drag" */ '../components/page/DragList.vue'),
                    meta: {title: '拖拽列表'}
                },
                {
                    // 拖拽Dialog组件
                    path: '/dialog',
                    component: () => import(/* webpackChunkName: "dragdialog" */ '../components/page/DragDialog.vue'),
                    meta: {title: '拖拽弹框'}
                },
                {
                    // 国际化组件
                    path: '/i18n',
                    component: () => import(/* webpackChunkName: "i18n" */ '../components/page/I18n.vue'),
                    meta: {title: '国际化'}
                },
                {
                    // 权限页面
                    path: '/permission',
                    component: () => import(/* webpackChunkName: "permission" */ '../components/page/Permission.vue'),
                    meta: {title: '权限测试', permission: true}
                },
                {
                    path: '/404',
                    component: () => import(/* webpackChunkName: "404" */ '../components/page/404.vue'),
                    meta: {title: '404'}
                },
                {
                    path: '/403',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/403.vue'),
                    meta: {title: '403'}
                },
                {
                    path: '/donate',
                    component: () => import(/* webpackChunkName: "donate" */ '../components/page/Donate.vue'),
                    meta: {title: '支持作者'}
                }
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: {title: '登录'}
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});
