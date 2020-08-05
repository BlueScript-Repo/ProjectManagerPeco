package com.projectmanager.util;

public class HTMLElements {

	public static final String SHEET_DETAILS_START = "<div class=\"tab-pane fade IS_FIRST\" id=\"SHEET_NAME\" role=\"tabpanel\"><div class=\"row\" style=\"margin-top:2%;\">     <div class=\"col-md-12 \">       <div class=\"table-responsive\">                        <table class=\"table table-colored inventoryDetails inventoryTableHeader\" style=\"display: block;\">         <thead>           <tr>            <th>#</th>            <th>Invnt</th>            <th>Material</th>            <th>Type</th>            <th>Method</th>            <th>Grd/Cls</th>            <th>Ends</th>            <th>Size</th>            <th>Qty</th>            <th>Base Supply Rate</th>            <th>Supply Rate</th>            <th>Base Erection Rate</th>            <th>Erection Rate</th>            <th>Supply Amount</th>            <th>Erection Amount</th>          </tr>          <tr>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th><input type=\"text\" style=\"width:45px;\" name=\"supplyPrsnt\" onchange=\"updateSupplyRate($(this));\"></th>            <th></th>            <th><input type=\"text\" style=\"width:45px;\" name=\"erectionPrsnt\" onchange=\"updateErectionRate($(this));\"></th>            <th></th>            <th></th>            <th></th>          </tr>        </thead>        <tbody id=\"tableContentDetails\">";
	public static final String SHEET_DETAILS_END = "</tbody></table></div></div></div></div>";

	public static final String CURRENT_PROJECTS = "<form id=\"projectDetails\" action=\"projectDetails\" method=\"POST\" ><div class=\"clearfix\"><h3 class=\"mt-4 float-left\">projectNameVal</h3><button type=\"submit\" class=\"float-left btn btn-sm btn-default ml-5 mt-4\">Select</button>\t\t\t\t\t</div><div class=\"separator clearfix\"></div><input type='hidden' name='projectId' value='projectIdVal'/><input type='hidden' name='projectName' value='projectNameVal'/><input type='hidden' name='projectDesc' value='projectDescVal'/></form>";

	public static final String NOTIFICATIONS = "<form action=\"notify\" onClick=\"this.submit();\" method=\"POST\"> "
			+ "<div class=\"row\">"
			+ " <div class=\"col-md-12 \">"
			+ "   <div class=\"projects pv-30 ph-20 feature-box bordered shadow text-center object-non-visible\" data-animation-effect=\"fadeInDownSmall\" data-effect-delay=\"100\">"
			+ "   <h3 name=\"projectName\">projectNameVal</h3>"
			+ "   <div class=\"separator clearfix\"></div>"
			+ " 	<p name=\"projectDesc\">projectDescVal</p>"
			+ "  </div>"
			+ " </div>   "
			+ "</div>"
			+"</form>";
 }
