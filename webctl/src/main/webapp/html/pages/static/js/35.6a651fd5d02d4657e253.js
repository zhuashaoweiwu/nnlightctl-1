webpackJsonp([35],{c3wB:function(e,a){},cK84:function(e,a,t){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var l={name:"",methods:{tableRowClassName:function(e){e.row;var a=e.rowIndex;return 1===a?"warning-row":3===a?"success-row":""},handleSizeChange:function(e){console.log("每页 "+e+" 条")},handleCurrentChange:function(e){console.log("当前页: "+e)}},data:function(){return{currentPage4:4,tableData2:[{date:"2016-05-02",name:"王小虎",address:"123"},{date:"2016-05-04",name:"王小虎",address:"12313"},{date:"2016-05-01",name:"王小虎",address:"123123"},{date:"2016-05-03",name:"王小虎",address:"123123"}]}}},s={render:function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",{staticClass:"box"},[e._m(0),e._v(" "),t("div",{staticClass:"table"},[[t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData2,"row-class-name":e.tableRowClassName}},[t("el-table-column",{attrs:{prop:"date",label:"行号"}}),e._v(" "),t("el-table-column",{attrs:{prop:"name",label:"资产目录"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"资产名称"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"申请人"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"库存状态"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"数量"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"申请状态"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"出入库"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"原因"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"备注"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"审批人"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"创建时间"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"修改时间"}}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"所属库存"}})],1)],e._v(" "),t("el-pagination",{attrs:{"current-page":e.currentPage4,"page-sizes":[100,200,300,400],"page-size":100,layout:"total, sizes, prev, pager, next, jumper",total:400},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],2)])},staticRenderFns:[function(){var e=this.$createElement,a=this._self._c||e;return a("div",{staticClass:"buttonList"},[a("div",[a("p",[this._v("55")]),this._v(" "),a("p",[this._v("申请中")])]),this._v(" "),a("div",[a("p",[this._v("55")]),this._v(" "),a("p",[this._v("待审批")])])])}]};var r=t("VU/8")(l,s,!1,function(e){t("c3wB")},"data-v-52445522",null);a.default=r.exports}});
//# sourceMappingURL=35.6a651fd5d02d4657e253.js.map