<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	-->
	<!-- 可选的Bootstrap主题文件（一般不用引入）
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
-->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" media="screen" href="/css/ui.jqgrid-bootstrap.css" />
    <script type="text/ecmascript" src="/js/jquery-1.11.0.min.js"></script>
    <script type="text/ecmascript" src="/js/i18n/grid.locale-en.js"></script>
	<script type="text/ecmascript" src="/js/jquery.jqGrid.min.js"></script>
    <script>
        $.jgrid.defaults.width = "1024";
        $.jgrid.defaults.styleUI = 'Bootstrap';
    </script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>-->
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li>
					<a href="#">主页</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="#">组件展示</a> <span class="divider">/</span>
				</li>
				<li class="active">
					DataGrid
				</li>
			</ul> <span class="badge">1</span>
			<div class="alert alert-success">
				 <button type="button" class="close" data-dismiss="alert">×</button>
				<h4>
					提示!
				</h4> <strong></strong> DataGrid 组件演示.
			</div>
            <div class="row-fluid">
                <div class="span12">
                    <div style="margin-left:20px;">
                        <table id="jqGrid" width="100%"></table>
                        <div id="jqGridPager" style="height: 50px;"></div>
                    </div>
                </div>
            </div>
            <!-- href="/abc/test?name=sdsa" -->
            <a id="modal-526735" data-toggle="modal" role="button" class="btn" data-target="#myModal"  >触发遮罩窗体</a>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                表单详情页
                            </h4>
                        </div>
                        <div class="modal-body">
                            在这里添加一些文本
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

            <script type="text/javascript">

                $(document).ready(function () {
                    $("#jqGrid").jqGrid({
                        colModel: [
                            {
                                label: '标题',
                                name: 'Title',
                                width: 150,
                                formatter: formatTitle
                            },
                            {
                                label: 'Link',
                                name: 'Link',
                                width: 80,
                                formatter: formatLink
                            },
                            {
                                label: 'View Count',
                                name: 'ViewCount',
                                width: 35,
                                sorttype:'integer',
                                formatter: 'number',
                                align: 'right'
                            },
                            {
                                label: 'Answer Count',
                                name: 'AnswerCount',
                                width: 25
                            }
                        ],

                        viewrecords: true, // show the current page, data rang and total records on the toolbar
                        width: 780,
                        height: 300,
                        rowNum: 15,
                        datatype: 'local',
                        pager: "#jqGridPager",
                        caption: "Load live data from stackoverflow"
                    });

                    fetchGridData();

                    function fetchGridData() {

                        var gridArrayData = [];
                        // show loading message
                        $("#jqGrid")[0].grid.beginReq();
                        $.ajax({
                            url: "abc/getdata?order=desc&sort=activity&tagged=jqgrid&site=stackoverflow",
                            success: function (result) {
                                for (var i = 0; i < result.items.length; i++) {
                                    var item = result.items[i];
                                    gridArrayData.push({
                                        Title: item.title,
                                        Link: item.link,
                                        CreationDate: item.creation_date,
                                        ViewCount: item.view_count,
                                        AnswerCount: item.answer_count
                                    });
                                }
                                // set the new data
                                $("#jqGrid").jqGrid('setGridParam', { data: gridArrayData});
                                // hide the show message
                                $("#jqGrid")[0].grid.endReq();
                                // refresh the grid
                                $("#jqGrid").trigger('reloadGrid');
                            }
                        });
                    }

                    function formatTitle(cellValue, options, rowObject) {
                        return cellValue.substring(0, 50) + "...";
                    };

                    function formatLink(cellValue, options, rowObject) {
                        return "<a href='" + cellValue + "'>" + cellValue.substring(0, 25) + "..." + "</a>";
                    };



                });

            </script>

		</div>
	</div>
</div>

</body>
</html>