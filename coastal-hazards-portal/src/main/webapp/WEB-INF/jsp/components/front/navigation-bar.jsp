<%-- Logo --%>
<a href="<%=request.getParameter("base-url")%>/" id="app-navbar-coop-logo-img-container" class="app-navbar-item-container">
    <img id="app-navbar-coop-logo-img" alt="Navigation Bar Cooperator Logo" src="images/banner/cida-cmgp.svg" />
</a>

<%-- Application Title --%>
<div id="app-navbar-site-title-container" class="app-navbar-item-container">
    <div class="app-navbar-title visible-lg hidden-md hidden-sm hidden-xs">USGS Coastal Change Hazards Portal</div>
    <div class="app-navbar-title hidden-lg visible-md hidden-sm hidden-xs">USGS Coastal Change Hazards</div>
    <div class="app-navbar-title hidden-lg hidden-md visible-sm hidden-xs">USGS Coastal Change Hazards</div>
    <div class="app-navbar-title hidden-lg hidden-md hidden-sm visible-xs">&nbsp;</div>
</div>

<%-- Combination Search Bar --%>
<jsp:include page="combined-searchbar.jsp"></jsp:include>

<%-- Bucket Control --%>
<jsp:include page="navbar-bucket.jsp"></jsp:include>

<%-- Help Button --%>
<div class='app-navbar-item-container'>
    <span id='app-navbar-help-container'
            data-toggle="popover" 
            data-trigger="hover" 
            data-placement="auto" 
            data-content="More Info For USGS Coastal Change Hazards Portal">
        <a href="<%=request.getContextPath()%>/info/"><i class="fa fa-info-circle"></i></a>
    </span>
</div>

<%-- This modal window appears when a user selects to share their session. It includes the 
    url for their current view (calculated on the fly) and a tweet button --%>
<div id="modal-content-share" class="modal fade" tabindex ="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" aria-hidden="true" data-dismiss="modal" type="button">�</button>
                <h4 id="modal-label">Share Your Coastal Change Hazards Portal View With Others</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="well well-small">
                        <div id="modal-share-summary-url-inputbox-div">
                            <input id="modal-share-summary-url-inputbox" type='text' autofocus readonly size="20" placeholder="Loading..." />
                        </div>
                        <a id="modal-share-summary-url-button" class="btn btn-default" target="portal_view_window" role="button">View In Portal</a>

                    </div>
                    <span class="pull-right" id='multi-card-twitter-button'></span>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-default"  data-dismiss="modal" aria-hidden="true">Close</a>
            </div>
        </div>
    </div>
</div>
