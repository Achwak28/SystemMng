(window.webpackJsonp=window.webpackJsonp||[]).push([[2],{584:function(t,e,r){var content=r(594);"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(4).default)("71fe9192",content,!0,{sourceMap:!1})},593:function(t,e,r){"use strict";var n=r(584);r.n(n).a},594:function(t,e,r){(e=r(3)(!1)).push([t.i,"@-webkit-keyframes spin-data-v-6c68c241{0%{transform:rotate(0deg)}to{transform:rotate(1turn)}}@keyframes spin-data-v-6c68c241{0%{transform:rotate(0deg)}to{transform:rotate(1turn)}}.category-page[data-v-6c68c241]{margin-top:24px}aside[data-v-6c68c241]{width:100%;max-width:224px;margin-right:32px}@media (max-width:768px){aside[data-v-6c68c241]{display:flex;max-width:100%;justify-content:space-between}}@media (max-width:768px){aside .styles-dropdown[data-v-6c68c241]{margin-right:16px}}main[data-v-6c68c241]{width:100%}main.full-width[data-v-6c68c241]{max-width:100%}",""]),t.exports=e},597:function(t,e,r){"use strict";r.r(e);r(15),r(13);var n=r(5),o=(r(258),r(52),r(12),r(11),r(14),r(25),r(30),r(31),r(23),r(9)),c=r(79),l=r(50),h=r(8),d=r(19);function y(object,t){var e=Object.keys(object);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(object);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(object,t).enumerable}))),e.push.apply(e,r)}return e}function f(t){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?y(Object(source),!0).forEach((function(e){Object(n.a)(t,e,source[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(source)):y(Object(source)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(source,e))}))}return t}var m={layout:"content",mixins:[c.a],name:"IllustrationsPage",asyncData:function(t){return Object(o.a)(regeneratorRuntime.mark((function e(){var r,n,o,c,h,y,f,m,O,T,C,w,P,E,path,S,data,x,j,v;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(r=t.params,n=t.app,o=t.store,c=t.error,h=t.redirect,t.route,y=null,f=null,m=o.state.i18n.locale,o.dispatch("setCurrentStyle",null),!(O=r.pathMatch.split("/"))[O.length-1].includes("style--")){e.next=12;break}return f=O[O.length-1].split("--")[1],e.next=10,n.$categoriesRepository.index({style_pretty_ids:f,locale:m});case 10:T=e.sent,o.commit(d.b,T.categories);case 12:if(C=Object(l.d)(O,o),w=C.formattedParams,P=C.currentCategoryPath,E=C.filterType,Object.keys(w).length||c({statusCode:404,message:"Wrong params"}),!P.length){e.next=25;break}return path="".concat(P.map((function(t){return t.pretty_id})).reverse().join("/")).concat(f?"/style--"+f:""),r.pathMatch!==path&&h(301,"/illustrations/".concat(f?path+"/style--"+f:path)),y=P[0],e.next=21,n.$stylesRepository.index({subject_pretty_ids:y.pretty_id});case 21:S=e.sent,o.dispatch("setCurrentStyles",S),e.next=26;break;case 25:o.dispatch("setCurrentStyles",o.state.styles);case 26:return e.prev=26,e.next=29,n.$illustrationsRepository.index(Object.assign({page:1,per_page:30,locale:m},w));case 29:return(data=e.sent).total||("Whoops, can't find illustrations with these params",c({statusCode:404,message:"Whoops, can't find illustrations with these params"})),e.next=33,n.$tagsRepository.index(Object.assign({locale:m},w));case 33:x=e.sent,j={image:"/vue-static/ouch/seo/opengraph.png"},e.t0=E,e.next="category"===e.t0?38:"search"===e.t0?41:"style"===e.t0?45:48;break;case 38:return j.title=n.$t("OUCH_V2.SEO.CONTENT.CATEGORY.TITLE",{term:y.title}),j.description=n.$t("OUCH_V2.SEO.CONTENT.CATEGORY.DESCRIPTION",{term:y.title}),e.abrupt("break",48);case 41:return v=w.search.replace("vector",""),j.title=n.$t("OUCH_V2.SEO.CONTENT.CATEGORY.TITLE",{term:Object(l.a)(v)}),j.description=n.$t("OUCH_V2.SEO.CONTENT.CATEGORY.DESCRIPTION",{term:Object(l.a)(v)}),e.abrupt("break",48);case 45:return j.title=n.$t("OUCH_V2.SEO.CONTENT.STYLE.TITLE",{style:o.state.currentStyle.title}),j.description=n.$t("OUCH_V2.SEO.CONTENT.STYLE.DESCRIPTION",{style:o.state.currentStyle.title}),e.abrupt("break",48);case 48:return o.dispatch("updateSEO",j),e.abrupt("return",{illustrations:data.illustrations,total:data.total,currentCategoryPath:P,subject:y,filterType:E,formattedParams:w,seoTags:x.tags,locale:m});case 52:e.prev=52,e.t1=e.catch(26),console.error(e.t1),c({statusCode:500,message:"Whoops, something went wrong..."});case 56:case"end":return e.stop()}}),e,null,[[26,52]])})))()},data:function(){return{illustrations:[],total:0,perPage:30,formattedParams:null,noSubcategories:!1,subject:null,currentCategoryPath:[],filterType:"",seoTags:[]}},computed:f(f({},Object(h.d)({currentStyle:function(t){return t.currentStyle},categories:function(t){return t.categories}})),{},{seoTitle:function(){var title="Free vectors";if(!this.formattedParams)return title;switch(this.filterType){case"category":title="".concat(this.subject.title," ").concat(this.$t("OUCH_V2.VECTOR_ILLUSTRATIONS"));break;case"search":title="".concat(this.formattedParams.search.replace(/-/g," "));break;case"style":this.currentStyle&&(title=this.$t("OUCH_V2.SEO_HEADER.STYLE_TITLE",{style:this.currentStyle.title}))}return title},showSidebar:function(){return!("search"===this.filterType||this.noSubcategories)}}),methods:{fetch:function(){this.nextPage("illustrations",Object.assign({locale:this.locale},this.formattedParams))}}},O=(r(593),r(0)),component=Object(O.a)(m,(function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"category-page container"},[r("ouch-seo-header",{attrs:{title:t.seoTitle,currentCategoryPath:t.currentCategoryPath,seoTags:t.seoTags,filterType:t.filterType,totalIllustrations:t.total}}),r("div",{staticClass:"content"},[t.showSidebar?r("aside",[r("ouch-styles-dropdown"),r("ouch-category-list",{attrs:{filterParams:t.formattedParams,currentCategoryPath:t.currentCategoryPath},on:{noSubcategories:function(e){t.noSubcategories=!0}}})],1):t._e(),t.illustrations.length?r("main",{class:{"full-width":!t.showSidebar}},[r("ouch-illustrations-list",{attrs:{illustrations:t.illustrations,total:t.total}}),t.page*t.perPage<this.total||t.nextPageLoading?r("ouch-pagination",{attrs:{entity:"illustrations",page:t.page,perPage:t.perPage,loading:t.nextPageLoading},on:{nextPage:t.fetch}}):t._e()],1):t._e()])],1)}),[],!1,null,"6c68c241",null);e.default=component.exports}}]);